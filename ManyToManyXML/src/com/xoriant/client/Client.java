package com.xoriant.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.Cart;
import com.xoriant.beans.Item;

public class Client {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();

		Item item1 = new Item();
		item1.setDescription("Mobile");
		item1.setCost(23224.34);
		
		Item item2 = new Item();
		item2.setDescription("Laptop");
		item2.setCost(67657.56);
		
		Set<Item> items1 = new HashSet<>();
		items1.add(item1);
		items1.add(item2);
		
		
		Set<Item> items2 = new HashSet<>();
		items2.add(item1);
		
		Cart cart = new Cart();
		cart.setDescription("THis is cart  1");
		cart.setItems(items1);
		
		Cart cart2 = new Cart();
		cart2.setDescription("THis is cart  1");
		cart2.setItems(items2);
		
		
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		session.save(cart);
		session.save(cart2);
		
		
		txn.commit();
		session.close();
		factory.close();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
