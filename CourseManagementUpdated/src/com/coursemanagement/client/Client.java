package com.coursemanagement.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanagement.service.CourseService;
import com.coursemanagement.service.StudentService;
import com.coursemanagement.beans.Student;
import com.coursemanagement.dao.CourseDaoImpl;




@Controller
@ComponentScan(basePackages = "com.coursemanagement.beans")
public class Client {	
	@RequestMapping(value="/student",method=RequestMethod.GET)
	 public @ResponseBody List<Student> getStudents(){ 
		 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CourseDaoImpl guestDao = (CourseDaoImpl) context.getBean("UserDao");
		List<Student> studList= guestDao.getAllStudents();
		ModelAndView modelAndView = new ModelAndView("Students");
		modelAndView.addObject("studentList",studList);
		return studList;
	}
	
	@RequestMapping(value="/student",method=RequestMethod.POST)
	  public @ResponseBody Student createStudent(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("dateofbirth") String dateofbirth)
	{
	
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CourseDaoImpl guestDao = (CourseDaoImpl) context.getBean("UserDao");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = simpleDateFormat.parse(dateofbirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student student = new Student(firstname,lastname,date);
		Integer id = guestDao.addStudent(student);
		System.out.println(id);
		
	
		ModelAndView modelAndView = new ModelAndView("Students");
		return student;
	}
	

	
	
}
