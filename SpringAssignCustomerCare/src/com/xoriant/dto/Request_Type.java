package com.xoriant.dto;

public enum Request_Type {

	NEW_CONNECTION(5),RELOCATION(8),ADDPACKAGE(2),RECHARGE(1),DISCONNECTION(3);
	
	private int days;

	Request_Type(int days){
		this.days = days;
	}
	
	public int getDays() {
		return days;
	}
	
}
