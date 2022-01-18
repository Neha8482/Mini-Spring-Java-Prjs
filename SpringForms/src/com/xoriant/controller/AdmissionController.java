package com.xoriant.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/hello")
public class AdmissionController {

	@RequestMapping(value="/admissionForm",method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		return modelAndView;
	}
	@RequestMapping(value="/submitForm",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student") Student student) {
	
		ModelAndView modelAndView = new ModelAndView("admissionSuccess");
		modelAndView.addObject("msg","Hello ");
		return modelAndView;
	}
	
	/* method 2 by creating object manually
	@RequestMapping(value="/submitForm",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String studentName,@RequestParam("hobby") String hobby ) {
		Student student = new Student();
		student.setStudentName(studentName);
		student.setHobby(hobby);
		
		ModelAndView modelAndView = new ModelAndView("admissionSuccess");
		modelAndView.addObject("msg","Hello ");
		modelAndView.addObject("student",student);
		return modelAndView;
	}*/
	/* method 1 
	@RequestMapping(value="/submitForm",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String studentName,@RequestParam("hobby") String hobby ) {
		ModelAndView modelAndView = new ModelAndView("admissionSuccess");
		modelAndView.addObject("msg","Hello "+studentName+" .... Your hobby is "+hobby);
		return modelAndView;
	}
	*/
}
