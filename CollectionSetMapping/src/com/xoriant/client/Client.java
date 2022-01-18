package com.xoriant.client;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Employee;

public class Client {
public static void main(String[] args) {
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	SessionFactory factory = meta.getSessionFactoryBuilder().build();
	
	Set<String> em = new HashSet<>();
	em.add("java");
	em.add("python");
	Employee employee = new Employee("Neeta",em);
	
	Session session = factory.openSession();
	Transaction txn = session.beginTransaction();
	
	session.save(employee);
		
	txn.commit();
	session.close();
	
	System.out.println("All Employees:  ");
	session = factory.openSession();
	List<Employee> allEmployees = session.createQuery("FROM Employee").getResultList();
	System.out.println(allEmployees);
	session.close();
	
	factory.close();
	
}
}
