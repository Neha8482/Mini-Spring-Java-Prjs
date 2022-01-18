package com.xoriant.dto;

import java.util.Date;

public class Request {

	private int requestid;
	private int executiveid;
	private Request_Type request_type;
	private Request_Status request_status;
	private String description;
	private Date request_date;
	private Date resolve_date;
	
	
	
	public Request(int requestid, int executiveid, Request_Type request_Type2, Request_Status request_Status2, String description,
			Date request_date, Date resolve_date) {
		super();
		this.requestid = requestid;
		this.executiveid = executiveid;
		this.request_type = request_Type2;
		this.request_status = request_Status2;
		this.description = description;
		this.request_date = request_date;
		this.resolve_date = resolve_date;
	}
	

	public Request() {
		// TODO Auto-generated constructor stub
	}

	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public int getExecutiveid() {
		return executiveid;
	}
	public void setExecutiveid(int executiveid) {
		this.executiveid = executiveid;
	}
	public Request_Type getRequest_type() {
		return request_type;
	}
	public void setRequest_type(Request_Type request_type) {
		this.request_type = request_type;
	}
	public Request_Status getRequest_status() {
		return request_status;
	}
	public void setRequest_status(Request_Status request_status) {
		this.request_status = request_status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}
	public Date getResolve_date() {
		return resolve_date;
	}
	public void setResolve_date(Date resolve_date) {
		this.resolve_date = resolve_date;
	}
	@Override
	public String toString() {
		return "\nrequestid=" + requestid + ", executiveid=" + executiveid + ", request_type=" + request_type
				+ ", request_status=" + request_status + ", description=" + description + ", request_date="
				+ request_date + ", resolve_date=" + resolve_date + "]";
	}
	
	
	
}
