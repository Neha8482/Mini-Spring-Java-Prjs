package com.coursemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.beans.Student;
import com.coursemanagement.dao.CourseDaoImpl;

@Service
public class StudentService {
	
	    private CourseDaoImpl userDao;
	 
	    public List<Student> getAllStudent() {
	        List<Student> StudentList = userDao.getAllStudents();
	        return StudentList;
	    }
	 
	    public Integer addStudent(Student Student) {
	       Integer userResponse = userDao.addStudent(Student);
	        return userResponse;
	    }
	 
	    public Student updateStudent(Student Student) {
	      userDao.updateStudent(Student);
	       return Student;
	    }
	 
	    public void deleteStudent(int cid) {
	       userDao.deleteStudent(cid);
	       // return userResponse;
	    }
	 

}
