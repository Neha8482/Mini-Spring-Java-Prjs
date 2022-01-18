package com.xoriant.controllers;

public class Project {
	public Integer id;
	public String org;
	public String dept;
	public String manager;
	public String employee;
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Project [org=" + org + ", dept=" + dept + ", manager=" + manager + ", employee=" + employee + "]";
	}
	
	

}

