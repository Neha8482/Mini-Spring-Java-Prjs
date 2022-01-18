package com.xoriant.beans;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //used for instantiation
@Aspect
public class Audience {
	
	@Pointcut("execution(* com.xoriant.beans.Performer.perform(..))")
	private void performance() {
		//System.out.println("Performing");
	}
	
	@Before("performance()")
	public void takeSeats() {
		System.out.println("The audience is taking their seats");
	}
	
	@Before("performance()")
	public void turnOffCellPhones() {
		System.out.println("The audience is turning off their cellphones");
	}
	
	@AfterReturning("performance()")
	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Boo Audience demanding refund");
	}
	
	@After("performance()")
	public void goHome() {
		System.out.println("Audience go home");
	}
}
