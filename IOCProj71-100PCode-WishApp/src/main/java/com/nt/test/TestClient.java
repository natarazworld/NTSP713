package com.nt.test;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class TestClient {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Target Bean class obj
		//generator=ctx.getBean("wmg",WishMessageGenerator.class);
		generator=ctx.getBean("wishMessageGenerator",WishMessageGenerator.class);
		//invoke method
		System.out.println("result is ::"+generator.generateMessage("raja"));
		System.out.println("...................");
		LocalDateTime  dt=ctx.getBean("createSysDateTime",LocalDateTime.class);
		System.out.println(dt);
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
