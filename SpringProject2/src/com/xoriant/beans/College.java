package com.xoriant.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class College {
	
	private String collegeName;
	private Project project;
	
	@Autowired
	public College(String collegeName,Project project) {
		super();
		this.collegeName = collegeName;
		this.project = project;
	}
	@Override
	public String toString() {
		return "College [collegeName=" + collegeName + ", project=" + project + "]";
	}
	
	

}
