package com.xoriant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.beans.Project;
import com.xoriant.dao.UserDao;
 
 
@Service
public class UserService {
   
    @Autowired
    private UserDao userDao;
 
    public List<Project> getAllUsers() {
        List<Project> userList = userDao.getAllUsers();
        return userList;
    }
 
    public Project getUserForId(int id) {
        Project project = userDao.getUserForId(id);
        return project;
    }
 
    public Project createUser(Project project) {
        Project userResponse = userDao.createUser(project);
        return userResponse;
    }
 
    public Project updateUser(Project project) {
        Project userResponse = userDao.updateUser(project);
        return userResponse;
    }
 
    public Project deleteUser(int id) {
        Project userResponse = userDao.deleteUser(id);
        return userResponse;
    }
 
}