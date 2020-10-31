package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.ILoginMgmtService;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		ILoginMgmtService service=ctx.getBean("loginService",ILoginMgmtService.class);
		try {
			//invoke method
			System.out.println(service.login("raja", "rani"));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main

}//class
