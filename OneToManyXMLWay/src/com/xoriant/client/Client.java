package com.xoriant.client;

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

import com.xoriant.beans.Company;
import com.xoriant.beans.Employee;

public class Client {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		Set<Employee> emps = new HashSet<>();
		emps.add(new Employee("Aalia"));
		emps.add(new Employee("Shweta"));
		emps.add(new Employee("Priya"));
		emps.add(new Employee("Katrina"));
		emps.add(new Employee("Rashmika"));
		
		Company company = new Company("Xoriant");
		company.setEmployees(emps);
		
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		session.save(company);
		
		txn.commit();
		session.close();
		
		System.out.println("Company:  ");
		session = factory.openSession();
		List<Company> allEmployees = session.createQuery("FROM Company").getResultList();
		System.out.println(allEmployees);
		session.close();
	
	
		factory.close();
		
		
	}

}
