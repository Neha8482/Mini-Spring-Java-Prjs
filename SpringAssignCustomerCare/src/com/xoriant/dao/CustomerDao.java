package com.xoriant.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xoriant.dto.Executive;
import com.xoriant.dto.Request;

public interface CustomerDao {

	public Map<String, Double> getChannelDetails(String fileName);
	
	public List<Request> populateRequests();
	
	public List<Executive> populateExecutives(List<Request> requests);
	
	public double calculatePackageAmount(List<String> selectedChannels, int
			noOfDays, Map<String, Double> availableChannels);
	
	public Set<Request> findUnassignedRequests(Set<Request> requests);
	
	public Map<Integer,Integer> searchAvailableExecutives(Request request,
			List<Executive> executives);
	
	public  Request assignRequest(Request request, Map<Integer,Integer>
	availableExecutives);
	
	public Executive closeRequest(int requestId, Set<Executive> executives,Date
			closeDate);
	
	public Map<Integer,List<Request>> getDelayedRequests(Set<Executive>
	executives);

}
