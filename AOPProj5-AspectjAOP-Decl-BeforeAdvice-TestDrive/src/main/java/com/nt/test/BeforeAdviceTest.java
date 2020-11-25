package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CarShowRoom;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		CarShowRoom proxy=ctx.getBean("showRoom",CarShowRoom.class);
		//invoke method
		System.out.println(proxy.sale("ritz",1200000, "giri"));
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
