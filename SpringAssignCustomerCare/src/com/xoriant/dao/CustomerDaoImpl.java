package com.xoriant.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.xoriant.dto.Executive;
import com.xoriant.dto.Request;
import com.xoriant.dto.Request_Status;
import com.xoriant.dto.Request_Type;

@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Map<String, Double> getChannelDetails(String fileName) {
		Map<String,Double> channelDetail = new HashMap<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("D://channeldetails.txt"));
			String c;
			while((c = br.readLine()) != null) {
				String[] st = c.split(":");
				String channel = st[0];
				Double price = Double.parseDouble(st[1]);
				channelDetail.put(channel, price);
			}
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return channelDetail;
	}

	@Override
	public List<Request> populateRequests() {
		return jdbcTemplate.query("select * from requestdetails", new ResultSetExtractor<List<Request>>() {
			@Override
			public List<Request> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Request> request = new ArrayList<Request>();
				while(rs.next()) {
					Request r = new Request();
					r.setRequestid(rs.getInt(1));
					r.setExecutiveid(rs.getInt(2));
					r.setRequest_type(Request_Type.valueOf(rs.getString(3).toUpperCase()));
					r.setRequest_status(Request_Status.valueOf(rs.getString(4)));
					r.setDescription(rs.getString(5));
					r.setRequest_date(rs.getDate(6));
					r.setResolve_date(rs.getDate(7));
					request.add(r);
				}
				return request;
			}
		});
	}

	@Override
	public List<Executive> populateExecutives(List<Request> requests) {
		List<Executive> executives = jdbcTemplate.query("select * from executivedetails", new ResultSetExtractor<List<Executive>>() {
			@Override
			public List<Executive> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Executive> exe = new ArrayList<Executive>();
				while(rs.next()) {
					Executive e = new Executive();
					e.setExecutiveid(rs.getInt(1));
					e.setExecutivename(rs.getString(2));
					e.setDepartment(rs.getString(3));
					e.setRequests(null);
					exe.add(e);
				}
				return exe;
			}
		});
       
		List<Request> reqs = new ArrayList<>(requests);
		for(int i =0 ; i < reqs.size();i++) {
			for(int j = 0; j< executives.size();j++) {
				if(reqs.get(i).getExecutiveid() == executives.get(j).getExecutiveid()) {
				//	List<Request> r = new ArrayList<>();
					Executive ec= executives.get(j);
					List<Request> r=ec.getRequests();
					if(r==null) {
					//	System.out.println("null");
						List<Request> req = new ArrayList<>();
						req.add(reqs.get(i));
						executives.get(j).setRequests(req);
					}
					else {
					r.add(reqs.get(i));
					}
				}
			}
		}
		
		return executives;
		
	}

	@Override
	public double calculatePackageAmount(List<String> selectedChannels, int noOfDays,
			Map<String, Double> availableChannels) {
		double packageamt = 0 ;
		for(Map.Entry<String, Double> entry: availableChannels.entrySet()) 
			if(selectedChannels.contains(entry.getKey()))
			packageamt = packageamt + (entry.getValue()*noOfDays);
		return packageamt;
	}

	@Override
	public Set<Request> findUnassignedRequests(Set<Request> requests) {
		Set<Request> unassignedreq = new HashSet<>();
		for(Request r : requests) {
			if(r.getExecutiveid()<=0) {
				unassignedreq.add(r);
			}
		}
		return unassignedreq;
	}

	@Override
	public Map<Integer, Integer> searchAvailableExecutives(Request request, List<Executive> executives) {
		Map<Integer,Integer> availableexecs = new HashMap<>();
		for(Executive e : executives) {
			int count =0;
			for(Request r : e.getRequests()) {
				if(r.getRequest_status() == Request_Status.valueOf("inprogress")) {
					count =count+1;
				}
			}
			availableexecs.put(e.getExecutiveid(), count);
		}
		return availableexecs;
	}

	@Override
	public Request assignRequest(Request request, Map<Integer, Integer> availableExecutives) {
		int minreqs =3;
		int minreqsexecid = 0;
		List<Request> re =populateRequests();
		List<Executive> exes =  populateExecutives(re);
		for(Map.Entry<Integer, Integer> entry: availableExecutives.entrySet()) {
			if(minreqs > entry.getValue()) {
				minreqs = entry.getValue();
				minreqsexecid= entry.getKey();
			}
		}
		if(minreqsexecid > 0) {
		request.setExecutiveid(minreqsexecid);
		request.setRequest_status(Request_Status.valueOf("inprogress"));
		for(Executive e : exes) {
			if(e.getExecutiveid()== minreqsexecid) {
				Executive ex = e;
				List<Request> reqs = e.getRequests();
				reqs.add(request);
			}
		}
		}
		
		return request;
	}

	@Override
	public Executive closeRequest(int requestId, Set<Executive> executives, Date closeDate) {
		List<Request> re =populateRequests();
		Executive ex = new Executive();
		for(Request r : re) {
			if(r.getRequestid() == requestId) {
				r.setRequest_status(Request_Status.valueOf("closed"));
				r.setResolve_date(new java.util.Date());
			}
		}
		for(Executive e : executives) {
			for(Request res : e.getRequests()) {
				if(res.getRequestid() == requestId) {
					res.setRequest_status(Request_Status.valueOf("closed"));
					res.setResolve_date(new java.util.Date());
					ex = e;
				}
			}
		}
		return ex;
	}

	@Override
	public Map<Integer, List<Request>> getDelayedRequests(Set<Executive> executives) {
		Map<Integer,List<Request>> delayedreqs = new HashMap<>();
		for(Executive e : executives) {
			List<Request> res = new ArrayList<>();
			for(Request r : e.getRequests()) {
				Date d1 = r.getRequest_date();
				Date d2 = r.getResolve_date();
				long diffinmillisec = d1.getTime() - d2.getTime();
				long diffindays = (diffinmillisec/(1000 * 24 * 60 * 60))%365;
				int days = r.getRequest_type().getDays();
				if(days > (diffindays-1)) {
					res.add(r);
				}
			}
			delayedreqs.put(e.getExecutiveid(), res);
		}
		
		
		return delayedreqs;
	}

	

}
