package com.xoriant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_data")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="emp_id")
	private Integer empID;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="exp")
	private int exp;

	
	public Employee(Integer empID, String empName, String designation, Integer exp) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.designation = designation;
		this.exp = exp;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEmpID() {
		return empID;
	}

	public void setEmpID(Integer empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", designation=" + designation + ", exp=" + exp
				+ "]";
	}

	
	
}
