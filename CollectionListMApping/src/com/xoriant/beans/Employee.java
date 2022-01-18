package com.xoriant.beans;

import java.util.List;

public class Employee {
	private Integer id;
	private String name;
	private List<String> technologyStack;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Employee( String name, List<String> technologyStack) {
		super();
		this.name = name;
		this.technologyStack = technologyStack;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTechnologyStack() {
		return technologyStack;
	}

	public void setTechnologyStack(List<String> technologyStack) {
		this.technologyStack = technologyStack;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", technologyStack=" + technologyStack + "]";
	}
	
	

}
