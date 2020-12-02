package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankService;

public class AroundAdviceTest {

	public static void main(String[] args) {
	   
		//create  IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		IBankService proxy=ctx.getBean("bankService",IBankService.class);
		System.out.println("Proxy object class name::"+proxy.getClass());
		//invoke methods
		System.out.println("simple intrest amount::"+proxy.calculateSimpleIntrestAmount(100000, 2, 12));
		System.out.println(".....................");
		System.out.println("compound intrest amount::"+proxy.calculateCompoundIntrestAmount(100000, 2, 12));
       //close container
		((AbstractApplicationContext) ctx).close();
		
		

	}

}
