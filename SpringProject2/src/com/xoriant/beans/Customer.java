package com.xoriant.beans;

import org.springframework.stereotype.Component;

@Component("customer")
public class Customer {
	
	private int customerid;
	private String customerName;
	private Address address;
	
	
	
	public Customer(int customerid, String customerName, Address address) {
		super();
		this.customerid = customerid;
		this.customerName = customerName;
		this.address = address;
	}
	
	



	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customerName=" + customerName + ", address=" + address + "]";
	}





	public Customer() {
		// TODO Auto-generated constructor stub
		System.out.println("Customer invoked");
	}

}
