package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class IocProj74BootDependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		//get IOC container
		ctx=SpringApplication.run(IocProj74BootDependencyInjectionApplication.class, args);
		System.out.println(ctx.getClass());
		//get Spring bean class object
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke method
		System.out.println(generator.generateWishMessage("raja"));
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
