package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.ShoppingStore;

public class AfterAdviceTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Proxy class object
		ShoppingStore proxy=ctx.getBean("shopping",ShoppingStore.class);
		//invoke method
		System.out.println("Bill Amount::"+proxy.shopping(new String[] {"Shirt", "Trouser","Belt"},
				                                                                                  new float[] {5000,3000,1000}));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
