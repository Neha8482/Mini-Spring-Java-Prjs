package com.xoriant.dto;

import java.util.List;

public class Executive {
	
	private int executiveid;
	private String executivename;
	private String department;
	private List<Request> requests;

	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}



	public int getExecutiveid() {
		return executiveid;
	}
	public void setExecutiveid(int executiveid) {
		this.executiveid = executiveid;
	}
	public String getExecutivename() {
		return executivename;
	}
	public void setExecutivename(String executivename) {
		this.executivename = executivename;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "\nExecutive [executiveid=" + executiveid + ", executivename=" + executivename + ", department="
				+ department + ", requests=" + requests + "]";
	}
	
	
}
