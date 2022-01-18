package com.xoriant.Client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.beans.Employee;
import com.xoriant.beans.Order;

public class Client {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	Employee employee = context.getBean(Employee.class);
	System.out.println(employee);
	
	Order order = context.getBean(Order.class);
	System.out.println(order);
}
}
