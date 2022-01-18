package com.xoriant.beans;

public class Employee {

	private Integer ID;
	private String name;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	

	public Employee(String name) {
		super();
		this.name = name;
	}


	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", name=" + name + "]";
	}
	
}
