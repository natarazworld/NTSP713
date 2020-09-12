package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component("vehicle")

public class Vehicle implements ApplicationContextAware {
	
	@Value("${dependent.id}")
	private String beanId;
	private ApplicationContext ctx;
	
	public Vehicle() {
		System.out.println("Vehicle:: 0-param constructor");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Vehicle.setApplicationContext(-)");
		 this.ctx=ctx;
		 
	}
	
	public  void  entertainment() {
		System.out.println("Vehicle is equipped with  DVD Player  for entertainment");
	}
	
	public  void soundHorn() {
		System.out.println("Vehicle  is equippled with skoda horn  ");
	}
	
	public  void  fillFuel() {
		System.out.println("Vehicle is having fuel tank of 50 liters");
	}
	
	
	  public void  journey(String  sourcePlace , String destPlace) {
		System.out.println("Vehicle.journey()");
		Engine engg=null;
		//get Dependent  Bean class object  (Dependency lookup)
		engg=ctx.getBean(beanId, Engine.class);
		//use dependent object
		engg.start();
		System.out.println("journey  started  at ::"+sourcePlace);
		System.out.println("journey is going on.......  from "+sourcePlace+" to "+destPlace);
		engg.stop();
		System.out.println("jounery ended at ::"+destPlace);
	}
	
}
