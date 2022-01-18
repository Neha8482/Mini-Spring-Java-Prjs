package com.xoriant.beans;

import java.util.HashMap;
import java.util.Map;

public class Order {

	private int orderid;
	private Map<Integer,Product> orderDetails;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Map<Integer, Product> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Map<Integer,Product> orderDetails) {
		this.orderDetails = new HashMap<>(orderDetails);
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderDetails=" + orderDetails + "]";
	}
	
	
	
	
}
