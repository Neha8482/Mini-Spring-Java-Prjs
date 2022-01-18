package com.xoriant.beans;

public class Address {
	private Integer addressId;
	private String city;
	private Employee employee;
	private String pincode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(String city,  String pincode) {
		super();
	
		this.city = city;
		this.pincode = pincode;
	}
	
	
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ","+ ", pincode=" + pincode
				+ "]";
	}
	
	
	
	
	

}
