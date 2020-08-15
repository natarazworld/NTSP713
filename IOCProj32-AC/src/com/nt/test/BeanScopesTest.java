package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.sdp.Printer;

public class BeanScopesTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator gen1=null;
		Printer p1=null;
		
		//create IOC container
		//ctx=new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
		//ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml"); //gradle App
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		//get Beans
		gen1=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println(gen1.generateWishMessage("raja"));
		System.out.println("...............................................");
		p1=ctx.getBean("p1",Printer.class);
		p1.printData("hello");
			 
		 //close container
		((AbstractApplicationContext) ctx).close();
		 
				
	}//main
}//class
