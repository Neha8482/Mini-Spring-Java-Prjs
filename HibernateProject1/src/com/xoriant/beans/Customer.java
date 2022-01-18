package com.xoriant.beans;

public class Customer {
	private Integer customer_Id;
	private String customerName;
	private String customerAddress;
	
	public Customer() {
		System.out.println("Customer Class");
	}

	public Integer getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(Integer customer_Id) {
		this.customer_Id = customer_Id;
	}



	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customer_Id + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + "]";
	}

	
}
