package com.coursemanagement.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Registration")
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int registrationid;
	int studentid;
	String coursename;
	String courseid;
	
	public Registration(int studentid, String coursename, String courseid) {
		super();
		this.studentid = studentid;
		this.coursename = coursename;
		this.courseid = courseid;
	}
	
	
	
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getRegistrationid() {
		return registrationid;
	}
	public void setRegistrationid(int registrationid) {
		this.registrationid = registrationid;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	@Override
	public String toString() {
		return "Registration [registrationid=" + registrationid + ", studentid=" + studentid + ", coursename="
				+ coursename + ", courseid=" + courseid + "]";
	}
	
	
	

}
