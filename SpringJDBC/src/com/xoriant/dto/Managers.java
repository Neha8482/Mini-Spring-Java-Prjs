package com.xoriant.dto;

public class Managers {

	private int managerId;
	private String managerName;
	private int subId;
	private String subName;
	
	public Managers() {
		// TODO Auto-generated constructor stub
	}
	public Managers(int managerId, String managerName, int subId, String subName) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.subId = subId;
		this.subName = subName;
	}
	@Override
	public String toString() {
		return "Managers [managerId=" + managerId + ", managerName=" + managerName + ", subId=" + subId + ", subName="
				+ subName + "]";
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	
}
