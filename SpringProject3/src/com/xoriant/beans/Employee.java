package com.xoriant.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee {

	private int empId;
	private String empName;
	private List<String> techStack;
	private Set<String> techs;
	private Set<Address> address;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public List<String> getTechStack() {
		return techStack;
	}
	public void setTechStack(List<String> techStack) {
		this.techStack = new ArrayList<>(techStack);
	}
	public Set<String> getTechs() {
		return techs;
	}
	public void setTechs(Set<String> techs) {
		this.techs = new HashSet<>(techs);
	}
	
	
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", techStack=" + techStack + ", techs=" + techs
				+ "]";
	}
	
	
	
}
