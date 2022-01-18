package com.xoriant.beans;

import org.springframework.stereotype.Component;

@Component("emp1")
public class Employee {

	public Employee() {
		System.out.println("Constructor invoked");
	}
}
