package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;
import com.nt.service.BankServiceImpl;

public class SpringAOPDeclTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class obj ref
		proxy=ctx.getBean("pfb",BankService.class);
		System.out.println(proxy.getClass()+"  "+proxy.getClass().getSuperclass()+"  "+Arrays.toString(proxy.getClass().getInterfaces()));
		//invoke the method
		System.out.println(" Intrest amount is::"+proxy.calcSimpleIntrestAmount(100000, 2, 12));
		System.out.println("========================================");
		System.out.println(" Intrest amount is::"+proxy.calcSimpleIntrestAmount(40000, 2, 12));

		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
