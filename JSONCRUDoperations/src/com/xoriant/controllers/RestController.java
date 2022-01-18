package com.xoriant.controllers;

	import java.util.List;
	 
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;

import com.xoriant.beans.Project;
import com.xoriant.service.UserService;
	 
	@Controller
	@RequestMapping("/user")
	public class RestController {
	 
	    @Autowired
	    private UserService userService;
	   
	    // CRUD -- CREATE operation
	    @RequestMapping(value = "/create", method = RequestMethod.POST)
	    public @ResponseBody Project createUser(Project project) {
	        Project userResponse = userService.createUser(project);
	        return userResponse;
	    }
	 
	    // CRUD -- READ operation
	    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	    public @ResponseBody List<Project> getAllUsers() {
	        List<Project> userList = userService.getAllUsers();
	        return userList;
	    }
	 
	    // CRUD -- READ operation
	    @RequestMapping(value = "/getSpecificUser/{id}", method = RequestMethod.GET)
	    public @ResponseBody Project getUserForId(@PathVariable ("id") int id) {
	        Project project = userService.getUserForId(id);
	        return project;
	    }
	 
	    // CRUD -- UPDATE operation
	    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	    public @ResponseBody Project updateUser(Project project) {
	        Project userResponse = userService.updateUser(project);
	        return userResponse;
	    }
	 
	    // CRUD -- DELETE operation
	    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	    public @ResponseBody Project deleteeUser(@PathVariable("id") int id) {
	        Project userResponse = userService.deleteUser(id);
	        return userResponse;
	    }
	}