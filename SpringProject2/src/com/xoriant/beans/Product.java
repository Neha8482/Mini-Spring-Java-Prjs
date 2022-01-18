package com.xoriant.beans;

public class Product {
	
	private int productid;
	private String productname;
	public Product(int productid, String productname) {
		super();
		this.productid = productid;
		this.productname = productname;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + "]";
	}
	
	

}
