package com.coursemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.beans.Course;
import com.coursemanagement.dao.CourseDaoImpl;

@Service
public class CourseService {
	
	    private CourseDaoImpl userDao;
	 
	    public List<Course> getAllCourses() {
	        List<Course> courseList = userDao.getAllCourses();
	        return courseList;
	    }
	 
	    public Integer addcourse(Course course) {
	       Integer userResponse = userDao.addCourse(course);
	        return userResponse;
	    }
	 
	    public void updateCourse(Course course) {
	      userDao.updateCourse(course);
	      //  return userResponse;
	    }
	 
	    public void deleteCourse(int cid) {
	       userDao.deleteCourse(cid);
	       // return userResponse;
	    }
	 

}
