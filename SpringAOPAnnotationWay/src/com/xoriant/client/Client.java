package com.xoriant.client;

import org.springframework.beans.factory.aspectj.AnnotationBeanConfigurerAspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.beans.Exam;
import com.xoriant.beans.Performer;


public class Client {
public static void main(String[] args) {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	//Performer performer = (Performer) context.getBean("performer");
	//performer.perform();
	
	Exam exam = (Exam) context.getBean("exam");
	try {
		exam.writeExam();
		exam.giveExam();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
}
}
