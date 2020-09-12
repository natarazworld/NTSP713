package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component("vehicle")
@Lazy
public class Vehicle {
	
	//@Value("engg")
	/*@Value("${dependent.id}")
	private String beanId;*/
	
	public Vehicle() {
		System.out.println("Vehicle:: 0-param constructor");
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
	
	/*  Version 1
	  public void  journey(String  sourcePlace , String destPlace) {
		System.out.println("Vehicle.journey()");
		Engine engg=null;
		ApplicationContext ctx=null;
		//create an extra IOC Container 
		 ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		  System.out.println("2nd IOC container");
		//get Dependent  Bean class object  (Dependency lookup)
		engg=ctx.getBean(beanId, Engine.class);
		//use dependent object
		engg.start();
		System.out.println("journey  started  at ::"+sourcePlace);
		System.out.println("journey is going on.......  from "+sourcePlace+" to "+destPlace);
		engg.stop();
		System.out.println("jounery ended at ::"+destPlace);
	}*/
	
	// version2   having  Container object  as parameter
	/*public void  journey(String  sourcePlace , String destPlace,ApplicationContext ctx) {
		System.out.println("Vehicle.journey()");
		Engine engg=null;
		//ApplicationContext ctx=null;
		//create an extra IOC Container 
		  //ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		  System.out.println("2nd IOC container");
		//get Dependent  Bean class object  (Dependency lookup)
		engg=ctx.getBean(beanId, Engine.class);
		//use dependent object
		engg.start();
		System.out.println("journey  started  at ::"+sourcePlace);
		System.out.println("journey is going on.......  from "+sourcePlace+" to "+destPlace);
		engg.stop();
		System.out.println("jounery ended at ::"+destPlace);
	}*/
	
	//version3 
	public void  journey(String  sourcePlace , String destPlace,ApplicationContext ctx,String beanId) {
		System.out.println("Vehicle.journey()");
		Engine engg=null;
		//ApplicationContext ctx=null;
		//create an extra IOC Container 
		  //ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		  //System.out.println("2nd IOC container");
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
