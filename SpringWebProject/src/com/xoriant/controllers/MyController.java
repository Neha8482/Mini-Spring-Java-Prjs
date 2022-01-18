package com.xoriant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class MyController {

	@RequestMapping("/welcome")
	public ModelAndView sayHello() {
		ModelAndView modelandview = new ModelAndView("Welcome");
		return modelandview;
	}
	
	@RequestMapping("/hi")
	public ModelAndView sayHi() {
		ModelAndView modelandview = new ModelAndView("Hi");
		modelandview.addObject("msg","Welcome to Spring MVC");
		return modelandview;
	}
}
