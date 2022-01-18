package com.xoriant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(
		{
			@NamedQuery(
					name="findEmployeeByName",
					query="from Employee e where e.name =:name"
					)
		}
		)
@Entity
@Table(name="empdata_10")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer empId;
	
	@Column(name="emp_ name")
	private String name;
	
	@Column(name="emp_designation")
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
