package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IBankServiceMgmt;

public class DTxMgmtTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		IBankServiceMgmt  proxy=ctx.getBean("bankService",IBankServiceMgmt.class);
		try {
			//invoke methods
			System.out.println(proxy.transferMoney(1005, 1002, 1000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
