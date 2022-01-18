package com.xoriant.client;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

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

	Employee emp1 = new Employee("Amit","Developer");
	Employee emp2 = new Employee("David","Sr.Developer");
	Employee emp3 = new Employee("John","Manager");
	Employee emp4 = new Employee("Jeff","Tech lead");
	
	Session session = factory.openSession();
	Transaction txn = session.beginTransaction();
	
	session.save(emp1);
	session.save(emp2);
	session.save(emp3);
	session.save(emp4);
	
	System.out.println("Fetch Data");
	
	TypedQuery<Employee> query = session.getNamedQuery("findEmployeeByName");
	query.setParameter("name", "amit");
	
	List<Employee> employees= query.getResultList();
	Iterator<Employee> itr = employees.iterator();
	
	while(itr.hasNext()) {
		Employee e= itr.next();
		System.out.println(e);
	}
	txn.commit();
	factory.close();
}
}
