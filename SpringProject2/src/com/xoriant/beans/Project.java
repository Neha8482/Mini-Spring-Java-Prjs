package com.xoriant.beans;

public class Project {

	private String projectName;

	public Project(String projectName) {
		super();
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Project [projectName=" + projectName + "]";
	}
	
	
}
