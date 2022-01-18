package com.xoriant.beans;

import java.util.Map;

public class Company {

	private Integer id;
	private String name;
	private Map<String,String> depts;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	public Company(String name, Map<String, String> depts) {
		super();
		this.name = name;
		this.depts = depts;
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
	public Map<String, String> getDepts() {
		return depts;
	}
	public void setDepts(Map<String, String> depts) {
		this.depts = depts;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", depts=" + depts + "]";
	}
	
	
	
}
