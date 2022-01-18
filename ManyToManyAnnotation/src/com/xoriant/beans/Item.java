package com.xoriant.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_2")
public class Item {
	
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer itemId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="cost")
	private double cost;
	
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getItemID() {
		return itemId;
	}
	public void setItemID(Integer itemID) {
		this.itemId = itemID;
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

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", description=" + description + ", cost=" + cost + "]";
	}
	
	
	

}
