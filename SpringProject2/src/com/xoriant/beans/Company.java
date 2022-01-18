package com.xoriant.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Company {
	private String companyName;
//	@Autowired //default byName
	private Project project;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Project getProject() {
		return project;
	}
	
	@Autowired //byType
	@Qualifier("project123")
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", project=" + project + "]";
	}
	
	
}
