package com.xoriant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deptemps_2")
public class Department {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="dept_id")
	private Integer deptId;
	
	@Column(name="dept_name")
	private String deptName;

	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
	
	
	
	
}
