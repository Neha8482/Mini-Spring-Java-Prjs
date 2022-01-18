package com.xoriant.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Company;


public class Client {
public static void main(String[] args) {
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	SessionFactory factory = meta.getSessionFactoryBuilder().build();
	

	Map<String,String> deptss = new HashMap<>();
	deptss.put("12","R&D");
	deptss.put("34", "L&D");
	
	Company company = new Company("ABC",deptss);
	
	Session session = factory.openSession();
	Transaction txn = session.beginTransaction();
	
	session.save(company);
		
	txn.commit();
	session.close();
	
	System.out.println("All Employees:  ");
	session = factory.openSession();
	List<Company> allEmployees = session.createQuery("FROM Company").getResultList();
	System.out.println(allEmployees);
	session.close();
	
	factory.close();

}
}
