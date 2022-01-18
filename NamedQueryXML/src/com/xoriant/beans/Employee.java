package com.xoriant.beans;

public class Employee {

	private Integer empId;
	private String name;
	private String designation;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee( String name, String designation) {
		super();
		this.name = name;
		this.designation = designation;
	}


	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + "]";
	}
	
	
}
