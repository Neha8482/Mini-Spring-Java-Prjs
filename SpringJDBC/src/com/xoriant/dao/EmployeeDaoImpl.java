package com.xoriant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.xoriant.dto.Employee;

@Component("empDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addEmployee(Employee employee) {
		String query = "insert into empdata values(?,?,?,?)";
		int result = jdbcTemplate.update(query, employee.getEmpId(),employee.getName(),employee.getSalary(),employee.getDesignation());
		if(result > 0)
			System.out.println("Record inserted in the database");
		else
			System.out.println("Not inserted");
	}

	@Override
	public void updateEmployee(int empId, double salary) {
		String query = "update empdata set salary = ? where empid = ?";
		int result = jdbcTemplate.update(query, salary,empId);
		if(result > 0)
			System.out.println("Salary updated in the database");
		else
			System.out.println("Salary Not Updated");
		
	}

	@Override
	public void deleteEmployee(int empId) {
		String query = "delete from empdata where empid = ?";
		int result = jdbcTemplate.update(query, empId);
		if(result > 0)
			System.out.println("Record deleted in the database");
		else
			System.out.println("Salary Not Deleted");
		
	}

	@Override
	public Employee getEmployee(int empId) {
		Employee empl = (Employee) jdbcTemplate.queryForObject("select * from empdata where empid = ?", new Object[] {empId}, (rs,rowNum) ->
		new Employee(
				rs.getInt(1),
				rs.getString(2),
				rs.getDouble(3),
				rs.getString(4)
				)
				);
		return empl;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("select * from empdata", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee e = new Employee();
				e.setEmpId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
			
		});
		
	}
		/*
		return jdbcTemplate.query("select * from empdata", new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<Employee> list = new ArrayList<Employee>();
					while(rs.next()) {
						Employee emp = new Employee();
						emp.setEmpId(rs.getInt(1));
						emp.setName(rs.getString(2));
						emp.setSalary(rs.getDouble(3));
						emp.setDesignation(rs.getString(4));
						list.add(emp);
					}
				return list;
			}
		});
	}*/

	@Override
	public List<Employee> getAllManagers() {
		
		List<Employee> managers = new ArrayList<>();
		List<Employee> rows  = getAllEmployees();
		for(Employee row : rows) {
			if(row.getDesignation().equals("Manager")) {
			Employee e = new Employee();
			e.setEmpId(row.getEmpId());
			e.setName(row.getName());
			e.setSalary(row.getSalary());
			e.setDesignation(row.getDesignation());
			managers.add(e);
			}
		}
		return managers;
	}

	@Override
	public void addManagers() {
		// TODO Auto-generated method stub
	
	}
}
