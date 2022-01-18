package com.xoriant.beans;

import org.springframework.stereotype.Component;

@Component("exam")
public class Exam {

	public void writeExam() throws Exception {
		System.out.println("Writing Exam....");
		//throw new Exception();
	}
	
	public void giveExam() {
		System.out.println("Giving Exam...");
	}
}
