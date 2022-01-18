package com.xoriant.beans;

import java.util.Set;

public class Project {
	
	private int projectid;
	private Set<Employee> employees;
	public Project(int projectid, Set<Employee> employees) {
		super();
		this.projectid = projectid;
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "\n\nprojectid=" + projectid + ",\n employees=" + employees + "]";
	}
	
	
	
	

}
