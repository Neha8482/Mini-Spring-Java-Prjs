package com.xoriant.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Customer;
import com.xoriant.beans.Product;

public class Client {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		Customer customer = new Customer();
		customer.setCustomerName("Prti");
		customer.setCustomerAddress("London");
		
		Product product = new Product();
		product.setProductName("sdawsfwa");
		product.setProductCost(1200.00);
		
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Integer id = (Integer) session.save(customer);
		System.out.println(id);
		Integer productID = (Integer) session.save(product);
		System.out.println(productID);

		txn.commit();
		session.close();
		factory.close();
	}
}
