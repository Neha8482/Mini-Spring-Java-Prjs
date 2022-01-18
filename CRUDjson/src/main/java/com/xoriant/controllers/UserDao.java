package com.xoriant.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import org.springframework.stereotype.Repository;
 
 
//Just to avoid DB calls in this example, Assume below data is interacting with DB
 
@Repository
public class UserDao {
    static HashMap<Integer, Project> usersMap = new HashMap<Integer, Project>();
 
    public UserDao() {
            Project project = new Project();
            project.setId(1);
            project.setOrg("abc");
            project.setDept("sinch");
            project.setManager("Harish");
            project.setEmployee("Parul");
           
            usersMap.put(1, project);
    }
 
    public List<Project> getAllProjects() {
 
        List<Project> userList = new ArrayList<Project>(usersMap.values());
        return userList;
    }
 
    public Project getProjectById(int id) {
        Project project = usersMap.get(id);
        return project;
    }
 
    public Project createProject(Project project) {
        usersMap.put(project.getId(), project);
        return usersMap.get(project.getId());
    }
 
    public Project updateProject(Project project) {
        if (usersMap.get(project.getId()) != null) {
           Project p =  usersMap.get(project.getId());
           p.setId(project.getId());
           p.setOrg(project.getOrg());
           p.setDept(project.getDept());
           p.setManager(project.getManager());
           p.setEmployee(project.getEmployee());
        } else {
            usersMap.put(project.getId(), project);
        }
        return usersMap.get(project.getId());
    }
 
    public Project deleteProject(int id) {
        Project userResponse = usersMap.remove(id);
        return userResponse;
    }
 
}