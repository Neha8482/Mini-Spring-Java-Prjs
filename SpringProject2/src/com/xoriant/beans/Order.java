package com.xoriant.beans;

public class Order {
	
	private int orderid;
	private Product product;
	public Order(int orderid, Product product) {
		super();
		this.orderid = orderid;
		this.product = product;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", product=" + product + "]";
	}
	
	

}
