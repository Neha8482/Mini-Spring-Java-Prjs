package com.xoriant.beans;

import java.util.Set;

public class Employee {

	private int empid;
	private Set<String> techs;
	public Employee(int empid, Set<String> techs) {
		super();
		this.empid = empid;
		this.techs = techs;
	}
	@Override
	public String toString() {
		return "\nEmployee [empid=" + empid + ", techs=" + techs + "]";
	}
	
	
}
