package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.ScheduleRemainder;


public class FactoryBeanTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ScheduleRemainder sr=null;
		  //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get target class object
		sr=ctx.getBean("remainder",ScheduleRemainder.class);
		//invoke methods
		System.out.println(sr.remainder());
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
}
