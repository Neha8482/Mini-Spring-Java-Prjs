package com.xoriant.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart_2")
public class Cart {

	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cartId;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany(targetEntity=Item.class,cascade= {CascadeType.ALL})
	@JoinTable(name="cart_items_2",joinColumns = {@JoinColumn(name="cart_id")},
	inverseJoinColumns = {@JoinColumn(name="item_id")})
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
