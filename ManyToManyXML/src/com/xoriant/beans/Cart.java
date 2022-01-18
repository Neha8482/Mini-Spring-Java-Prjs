package com.xoriant.beans;

import java.util.Set;

public class Cart {

	private Integer cartId;
	private String description;
	private Set<Item> items;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", description=" + description + ", items=" + items + "]";
	}
	
	
}
