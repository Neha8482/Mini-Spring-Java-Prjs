package com.xoriant.beans;

import org.springframework.stereotype.Component;

@Component("performer")
public class Performer {

	public void perform() {
		System.out.println("AAAAAA");
		//throw new Exception();
	}
}
