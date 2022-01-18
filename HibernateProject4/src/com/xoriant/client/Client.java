package com.xoriant.client;

import com.xoriant.beans.Regular_Employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Contract_Employee;
import com.xoriant.beans.Employee;

public class Client {
public static void main(String[] args) {
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	SessionFactory factory = meta.getSessionFactoryBuilder().build();
	
	Employee employee = new Employee("Neeta");
	Regular_Employee regualr_Employee = new Regular_Employee("Seeeta",50000,10000);
	Contract_Employee contract_employee = new Contract_Employee("Geeta", 1200, "24 months");
	
	Session session = factory.openSession();
	Transaction txn = session.beginTransaction();
	
	session.save(employee);
	session.save(regualr_Employee);
	session.save(contract_employee);
	
	txn.commit();
	session.close();
	
	System.out.println("All Employees:  ");
	session = factory.openSession();
	List<Employee> allEmployees = session.createQuery("FROM Employee").getResultList();
	System.out.println(allEmployees);
	session.close();
	
	System.out.println("All Regular Employees:  ");
	session = factory.openSession();
	List<Regular_Employee> allRegularEmployees = session.createQuery("FROM Regular_Employee").getResultList();
	System.out.println(allRegularEmployees);
	session.close();
	
	System.out.println("All Contract Employees:  ");
	session = factory.openSession();
	List<Contract_Employee> allContractEmployees = session.createQuery("FROM Contract_Employee").getResultList();
	System.out.println(allContractEmployees);
	session.close();
	
	factory.close();
	
}
}
