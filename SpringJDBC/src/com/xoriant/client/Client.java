package com.xoriant.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.dao.EmployeeDao;
import com.xoriant.dao.EmployeeDaoImpl;
import com.xoriant.dto.Employee;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//Employee employee1 = new Employee(22,"Prashant",776878,"Manager");
		EmployeeDaoImpl employeeDao = (EmployeeDaoImpl) context.getBean("empDao");
	//	employeeDao.addEmployee(employee1);
		
		
	//	employeeDao.updateEmployee(13, 430000);
//		employeeDao.deleteEmployee(11);
		List<Employee> employees = new ArrayList<>();
	/*	employees = employeeDao.getAllEmployees();
		System.out.println(employees);
		
		Employee e = employeeDao.getEmployee(14);
		System.out.println(e);
		
	*/	employees = employeeDao.getAllManagers();
		System.out.println(employees);
	

	}

}
