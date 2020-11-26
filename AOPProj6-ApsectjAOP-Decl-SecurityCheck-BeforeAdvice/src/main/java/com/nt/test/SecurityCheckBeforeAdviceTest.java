package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.manager.AuthenticationManager;
import com.nt.service.IBankService;

public class SecurityCheckBeforeAdviceTest {

	public static void main(String[] args) {
		//create  IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		IBankService proxy=ctx.getBean("bankService",IBankService.class);
		//get AuthenticationManager object
		AuthenticationManager manager=ctx.getBean("authManager",AuthenticationManager.class);
		try {
		   manager.signIn("raja", "rani");
		   System.out.println("withdraw operation::"+proxy.withdrawMoney(1001, 2000));
		   System.out.println("deposite operation::"+proxy.depositeMoney(1002, 2000));
		   manager.signOut();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
