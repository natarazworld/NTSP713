package com.nt.beans;

import java.util.Date;

public class Voter {
	private String name;
	private float age;
	private  Date  dov;
	
	public Voter() {
		System.out.println("Voter:: 0-param constructor");
	}
	
	public void setName(String name) {
		System.out.println("Voter.setName()");
		this.name = name;
	}
	public void setAge(float age) {
		System.out.println("Voter.setAge()");
		this.age = age;
	}
	public void setDov(Date dov) {
		System.out.println("Voter.setDov()");
		this.dov = dov;
	}
	
	// init life cycle method /custom life cycle method
	public  void myInit() {
		System.out.println("Voter.myInit()");
		dov=new Date();  // initializing left over properties
		boolean flag=false;
		if(name==null) {   // validation  logic
			System.out.println(" name must not be null");
			flag=true;
		}
		
		if(age<0)
			age=age*-1;  //correcting the values //Bean post processing
		
		if(age>100) {  //validation  logic
			System.out.println(" age must not >100");
			flag=true;
		}
		if(flag)
			throw new IllegalArgumentException(" invalid inputs");
		
	}
	
	// destroy life cycle method/custom destroy method
	public void myDestroy() {
		System.out.println("Voter.myDestroy()");
		 //nullify bean properties
		name=null;
		age=0;
		dov=null;
	}
	
	//b.method
	public String   checkVotingElgibility() {
		System.out.println("Voter.checkVotingElgibility()");
		//b.logic
		if(age>=18)
			return  "Mr/Miss/Mrs."+name+ "  u  r  eglible for voting::"+age+"-->  on  ->"+dov;
		else
			return  "Mr/Miss/Mrs."+name+ "  u  r not  eglible for voting::"+age+"--> on->"+dov;
	}//method

}//class
