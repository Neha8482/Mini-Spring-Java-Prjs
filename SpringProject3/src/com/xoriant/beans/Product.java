package com.xoriant.beans;

public class Product {
	
	private int productid;
	private String productName;
	public Product(int productid, String productName) {
		super();
		this.productid = productid;
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productName=" + productName + "]";
	}
	
	
	
	

}
