package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.BankLoanMgmt;

public class MethodInjectionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankLoanMgmt bank=null;
		  //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get target class object
		bank=ctx.getBean("bank",BankLoanMgmt.class);
		System.out.println(bank.getClass()+"  " +bank.getClass().getSuperclass());
		//invoke methods
		System.out.println("Intrest Amount:::"+bank.calculateIntrestAmount(100000, 2, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
