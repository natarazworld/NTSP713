package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankServiceImpl;
import com.nt.service.IBankService;

public class AspectjAopArounAdviceTest {

	public static void main(String[] args) {
		//create  IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class object
		IBankService proxy=ctx.getBean("bankService",IBankService.class);
		System.out.println(proxy.getClass()+"   "+proxy.getClass().getSuperclass()+" "+Arrays.toString(proxy.getClass().getInterfaces()));
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
