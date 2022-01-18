package com.xoriant.client;

import java.util.List;

import com.xoriant.beans.Employee;
import com.xoriant.dao.EmployeeDaoImpl;

public class Client {
public static void main(String[] args) {
	EmployeeDaoImpl emp = new EmployeeDaoImpl();
	
	Employee employee = new Employee();
	employee.setEmpName("Joey");
	employee.setDesignation("Test Lead");
	employee.setExp(3);
	
//	emp.addEmployee(employee);
	//emp.deleteEmployee(6);
	List<Employee> emplo = emp.listEmployees();
	System.out.println(emplo);
	
	List<String> employeeNames = emp.getEmployeeNames();
	System.out.println(employeeNames);
	
	Integer i = 3;
	List<Employee> empl = emp.orderByNames();
	System.out.println(empl);
}
}
