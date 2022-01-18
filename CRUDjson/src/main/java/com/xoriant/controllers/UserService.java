package com.xoriant.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


 
 
@Service
public class UserService {
   
    @Autowired
    private UserDao userDao;
 
    public List<Project> getAllProjects() {
        List<Project> userList = userDao.getAllProjects();
        return userList;
    }
 
    public Project getProjectById(int id) {
        Project project = userDao.getProjectById(id);
        return project;
    }
 
    public Project createProject(Project project) {
        Project userResponse = userDao.createProject(project);
        return userResponse;
    }
 
    public Project updateProject(Project project) {
        Project userResponse = userDao.updateProject(project);
        return userResponse;
    }
 
    public Project deleteProject(int id) {
        Project userResponse = userDao.deleteProject(id);
        return userResponse;
    }
 
}