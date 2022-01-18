package com.xoriant.beans;

import java.util.HashSet;
import java.util.Set;

public class Company {

	private String name;
	private Set<Department> dept;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Department> getDept() {
		return dept;
	}
	public void setDept(Set<Department> dept) {
		this.dept = new HashSet<>(dept);
	}
	
	
	public Company(String name, Set<Department> dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ",\n\n dept=" + dept + "]";
	}
	
	
}
