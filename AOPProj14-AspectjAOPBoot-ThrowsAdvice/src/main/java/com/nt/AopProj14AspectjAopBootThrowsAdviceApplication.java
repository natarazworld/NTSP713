package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.nt.service.ShoppingStore;

@SpringBootApplication
public class AopProj14AspectjAopBootThrowsAdviceApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(AopProj14AspectjAopBootThrowsAdviceApplication.class, args);
	    //get Proxy object
		ShoppingStore proxy=ctx.getBean("shopping",ShoppingStore.class);
		//invoke methods
		try {
			System.out.println("Bill amt::"+proxy.generateBill(new String[] {"shirt","trouser","belt"}, new float[] {4000,5000,2000}));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("=================================");
		try {
			System.out.println("Bill amt::"+proxy.generateBill(new String[] {"shirt","trouser","belt"}, new float[] {-4000,5000,2000}));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

		//close container 
		((ConfigurableApplicationContext) ctx).close();
	}

}
