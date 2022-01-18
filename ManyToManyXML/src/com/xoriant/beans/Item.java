package com.xoriant.beans;

import java.util.Set;

public class Item {
	private Integer itemId;
	private String description;
	private double cost;
	private Set<Cart> carts;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	@Override
	public String toString() {
		return "Item [itemID=" + itemId + ", description=" + description + ", cost=" + cost + ", carts=" + carts + "]";
	}
	
	
	

}
