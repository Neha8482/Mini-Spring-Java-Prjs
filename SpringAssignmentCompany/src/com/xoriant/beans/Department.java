package com.xoriant.beans;

import java.util.Map;

public class Department {
	
	private int deptid;
	private String deptName;
	
	private Map<Project,Integer> projects;
	
	
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Map<Project, Integer> getProjects() {
		return projects;
	}
	public void setProjects(Map<Project, Integer> projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "\n\nDepartment [\n deptid=" + deptid + ",  deptName=" + deptName + ",\n projects=" + projects + "]";
	}
	
	
	

}
