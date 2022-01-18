package com.xoriant.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Address;
import com.xoriant.beans.Employee;

public class Client {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		
		Address  address = new Address("Mumbai","121");
		
		Employee employee = new Employee("Hari",address);
		address.setEmployee(employee);
		
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
