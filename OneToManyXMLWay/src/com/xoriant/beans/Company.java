package com.xoriant.beans;

import java.util.Set;

public class Company {
	private Integer id;
	private String company_name;
	private Set<Employee> employees;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String company_name) {
		super();	
		this.company_name = company_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", company_name=" + company_name + ", employees=" + employees + "]";
	}
	
	
	

}
