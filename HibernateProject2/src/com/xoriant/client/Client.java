package com.xoriant.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.xoriant.beans.College;
import com.xoriant.beans.Student;

public class Client {
public static void main(String[] args) {
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	SessionFactory factory = meta.getSessionFactoryBuilder().build();
	
	Student student = new Student();
	student.setStudentName("Aditi");
	student.setGrade('A');
	
	College college = new College();
	college.setCollegeName("COEP");
	college.setCollegeAddress("Pune");
	
	Session session = factory.openSession();
	Transaction txn = session.beginTransaction();
	
	Integer id = (Integer) session.save(student);
	System.out.println(id);
	Integer cid = (Integer) session.save(college);
	System.out.println(cid);
	
	txn.commit();
	session.close();
	factory.close();
}
}
