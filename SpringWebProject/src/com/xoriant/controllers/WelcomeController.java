package com.xoriant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome/{userName}")
	public ModelAndView greet(@PathVariable("userName") String name) {
		ModelAndView modelandview = new ModelAndView("Welcome");
		modelandview.addObject("msg", "Welcome "+name);
		return modelandview;
	}
}
