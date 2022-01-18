package com.xoriant.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xoriant.dao.CustomerDao;
import com.xoriant.dao.CustomerDaoImpl;
import com.xoriant.dto.Executive;
import com.xoriant.dto.Request;

@Component
@RequestMapping("/hello")
public class CustomerController {

    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	CustomerDaoImpl cust = (CustomerDaoImpl) context.getBean(CustomerDaoImpl.class);
	@RequestMapping("/requests")
	public ModelAndView getRequests() {
		List<Request> ree =  cust.populateRequests();
		ModelAndView modelAndView = new ModelAndView("Allcustomers");
		modelAndView.addObject("ree",ree);
		return modelAndView;
	}
	
	@RequestMapping("/channels")
	public ModelAndView getChannels() {
		Map<String,Double> channels = new HashMap<>(); 
		channels =  cust.getChannelDetails("nnk");
		ModelAndView modelAndView = new ModelAndView("Channels");
		modelAndView.addObject("channels",channels);
		return modelAndView;
	}
	
	@RequestMapping("/executives")
	public ModelAndView getExecutives() {
		List<Request> re = cust.populateRequests();
		List<Executive> exes =  cust.populateExecutives(re);
		System.out.println(exes);
		ModelAndView modelAndView = new ModelAndView("Executives");
		modelAndView.addObject("executives",exes);
		return modelAndView;
	}
	
	@RequestMapping("/package")
	public ModelAndView calcPackage() {
		List<String> channelsList = new ArrayList<>();
		channelsList.add("Sony");
		Map<String,Double> channels = new HashMap<>(); 
		channels =  cust.getChannelDetails("nnk");
		double cost = cust.calculatePackageAmount(channelsList, 20,channels);
		ModelAndView modelAndView = new ModelAndView("PackageCost");
		modelAndView.addObject("cost",cost);
		return modelAndView;
	}
	
	@RequestMapping("/unassignedreqs")
	public ModelAndView unassigned() {
		List<Request> re = cust.populateRequests();
		Set<Request> requests = new HashSet<>(re);
		Set<Request> res = cust.findUnassignedRequests(requests);
		ModelAndView modelAndView = new ModelAndView("UnassignedReqs");
		modelAndView.addObject("reqs",res);
		return modelAndView;
	}
	
	@RequestMapping("/availabeexecs")
	public ModelAndView availableexecs() {
		List<Request> re = cust.populateRequests();
		List<Executive> exes =  cust.populateExecutives(re);
		System.out.println(exes);
		Request r = new Request();
		Map<Integer,Integer> executive = new HashMap<>();
		executive = cust.searchAvailableExecutives(r, exes);
		ModelAndView modelAndView = new ModelAndView("Unassignedexecs");
		modelAndView.addObject("exe",executive);
		return modelAndView;
	}
	
}
