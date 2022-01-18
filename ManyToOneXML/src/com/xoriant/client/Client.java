package com.xoriant.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Department;
import com.xoriant.beans.Employee;

public class Client {
public static void main(String[] args) {
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	SessionFactory factory = meta.getSessionFactoryBuilder().build();

	Employee emp1 = new Employee("karry");
	Employee emp2 = new Employee("David");
	Employee emp3 = new Employee("John");
	Employee emp4 = new Employee("Jeff");
	
	Department dept = new Department();
	dept.setDeptName("Admin1");
	
	emp1.setDepartment(dept);
	emp2.setDepartment(dept);
	emp3.setDepartment(dept);
	emp4.setDepartment(dept);
	
	
	Session session = factory.openSession();
	Transaction txn = session.beginTransaction();
	
	//session.save(dept);
	
	session.save(emp1);
	session.save(emp2);
	session.save(emp3);
	session.save(emp4);
	
	txn.commit();
	
	session.close();
	factory.close();	
	
	
}
}
