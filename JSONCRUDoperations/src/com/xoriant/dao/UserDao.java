package com.xoriant.dao;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	 
	import org.springframework.stereotype.Repository;
	 
import com.xoriant.beans.Project;
	 
	//Just to avoid DB calls in this example, Assume below data is interacting with DB
	 
	@Repository
	public class UserDao {
	    static HashMap<Integer, Project> usersMap = new HashMap<Integer, Project>();
	 
	    public UserDao() {
	            Project project = new Project();
	   
	            project.setOrg("abc");
	            project.setDept("sinch");
	            project.setManager("Harish");
	            project.setEmployee("Parul");
	           
	            usersMap.put(1, project);
	    }
	 
	    public List<Project> getAllUsers() {
	 
	        List<Project> userList = new ArrayList<Project>(usersMap.values());
	        return userList;
	    }
	 
	    public Project getUserForId(int id) {
	        Project project = usersMap.get(id);
	        return project;
	    }
	 
	    public Project createUser(Project project) {
	        usersMap.put(project.getId(), project);
	        return usersMap.get(project.getId());
	    }
	 
	    public Project updateUser(Project project) {
	        if (usersMap.get(project.getId()) != null) {
	            usersMap.get(project.getId()).setEmployee(project.getEmployee());
	        } else {
	            usersMap.put(project.getId(), project);
	        }
	        return usersMap.get(project.getId());
	    }
	 
	    public Project deleteUser(int id) {
	        Project userResponse = usersMap.remove(id);
	        return userResponse;
	    }
	 
	}