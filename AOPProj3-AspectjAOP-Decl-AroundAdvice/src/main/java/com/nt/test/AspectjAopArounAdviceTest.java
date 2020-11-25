package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class AspectjAopArounAdviceTest {

	public static void main(String[] args) {
		//create  IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class object
		BankService proxy=ctx.getBean("bankService",BankService.class);
		//invoke method on proxy object
		System.out.println("Simple Intrest amount is ::"+proxy.calculateSimpleIntrestAmount(10000,2, 12));
		System.out.println("------------------------------------------------------");
		System.out.println("compound Intrest amount is ::"+proxy.calculateCompoundIntrestAmount(10000,2, 12));
		System.out.println("==============================================");
		System.out.println("compound Intrest amount is ::"+proxy.calculateCompoundIntrestAmount(10000,2, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
