package com.xoriant.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.beans.Hotel;



@Controller
@RequestMapping("/project")
public class Client {
	@RequestMapping("/hotel")
	public ModelAndView getRequests() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			Hotel hotel =  (Hotel) context.getBean("Hotel");
		hotel.setHotelName("dgedg");
		
		List<Hotel> hotels = new ArrayList<>();
		hotels.add(hotel);
		ModelAndView modelAndView = new ModelAndView("Hotels");
		modelAndView.addObject("hotels",hotels);
		return modelAndView;
	}
}
