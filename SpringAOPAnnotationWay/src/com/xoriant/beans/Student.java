package com.xoriant.beans;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Student {

	@Pointcut("execution(* com.xoriant.beans.Exam.writeExam(..))")
	private void performance() {
	}
	
	@Pointcut("execution(* com.xoriant.beans.Exam.giveExam(..))")
	private void perform() {
	}
	
	@Before("performance()")
	public void arrangeThings() {
		System.out.println("Taken everything needed-Hall Ticket,Pen etc");
	}
	
	@Before("perform()")
	public void reachVenue() {
		System.out.println("Reached Venue");
	}
	
	@Before("performance()")
	public void checkHallTicket() {
		System.out.println("Hall Ticket Checking done.Now Entering Exam Hall");
	}
	
	@AfterThrowing("performance()")
	public void wrongPaperassigned() {
	//	System.out.println("Change Question Paper");
	}
	
	@AfterReturning("perform()")
	public void submitPaper() {
		System.out.println("Submitting paper");
	}
	
	@After("performance()")
	public void leaveHall() {
		System.out.println("Leave Hall");
	}
	
}
