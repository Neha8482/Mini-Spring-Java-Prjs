package com.xoriant.Client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.beans.Performer;

public class Client {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	Performer performer = context.getBean(Performer.class);
	try {
		performer.perform();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
}
}
