package com.xoriant.beans;

public class Employee {

	private int empid;
	private String empName;
	private Address address;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
		System.out.println("Employee object created");
	}
	
	
	
	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", address=" + address + "]";
	}


	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void printMsg() {
		System.out.println("Method from Employee Class");
	}
	
	
}
