package com.xoriant.controllers;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class RestController {
 
    @Autowired
    private UserService userService;
   
    // CRUD -- CREATE operation
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Project createUser(Project project) {
        Project userResponse = userService.createProject(project);
        System.out.println("CREATED");
        return userResponse;
    }
 
    // CRUD -- READ operation
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public @ResponseBody List<Project> getAllUsers() {
        List<Project> userList = userService.getAllProjects();
        return userList;
    }
 
    // CRUD -- READ operation
    @RequestMapping(value = "/getSpecificUser/{id}", method = RequestMethod.GET)
    public @ResponseBody Project getUserForId(@PathVariable ("id") int id) {
    	Project project = null;
    		  project = userService.getProjectById(id);
    	if(project == null) {
    		
    		System.out.println("User with specified ID does not exist");
    		return null;
    	}
    	else 
        return project;
    }
 
    // CRUD -- UPDATE operation
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public @ResponseBody Project updateUser(Project project) {
        Project userResponse = userService.updateProject(project);
        System.out.println("Updated");
        return userResponse;
    }
 
    // CRUD -- DELETE operation
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Project deleteeUser(@PathVariable("id") int id) {
        Project userResponse = userService.deleteProject(id);
        System.out.println("DELETED");
        return userResponse;
    }
}