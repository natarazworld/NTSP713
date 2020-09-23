package com.nt.beans;

import java.time.LocalDate;


import org.springframework.beans.factory.FactoryBean;

public class DateFactoryBean implements FactoryBean<LocalDate> {
	private  int year;
	private  int month;
	private int day;
	

	public DateFactoryBean(int year, int month, int day) {
	   System.out.println("DateFactoryBean.DateFactoryBean()");
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public LocalDate getObject() throws Exception {
		System.out.println("DateFactoryBean.getObject()");
		return  LocalDate.of(year,month,day);
	}

	@Override
	public Class<?> getObjectType() {
		return LocalDate.class;    // returns the Object of java.lang.Class  having  LocalDate as class name
	}
	
	@Override
	public boolean isSingleton() {   
		System.out.println("DateFactoryBean.isSingleton()");
	   return false;   //decide this  based getObject() method logic...
	                             //of getObject() method returs single object always then go for true otherwise go for false..
	}
}
