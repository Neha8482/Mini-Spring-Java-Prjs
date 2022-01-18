package com.xoriant.beans;

public class Employee {
	private Integer empId;
	private String name;
	private Address address;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + "]";
	}
	
	
	

}
