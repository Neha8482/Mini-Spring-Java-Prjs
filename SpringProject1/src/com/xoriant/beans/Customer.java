package com.xoriant.beans;

public class Customer {

	private int customerid;
	private String customerName;
	private Address address;
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customerName=" + customerName + ", address=" + address + "]";
	}
	public Customer(int customerid, String customerName, Address address) {
		super();
		this.customerid = customerid;
		this.customerName = customerName;
		this.address = address;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerNmae(String customerNmae) {
		this.customerName = customerName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
