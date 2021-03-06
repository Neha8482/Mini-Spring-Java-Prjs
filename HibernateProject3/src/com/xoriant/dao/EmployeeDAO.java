package com.xoriant.dao;

import java.util.List;

import com.xoriant.beans.Employee;

public interface EmployeeDAO {

	public Integer addEmployee(Employee employee);
	public void updateEmployee(Integer employeeId,int exp);
	public void deleteEmployee(Integer employeeId);
	public List<Employee> listEmployees();
	public List<String> getEmployeeNames();
	public List<Employee> searchByID(Integer id);
	
	public List<Employee> orderByNames();
}
