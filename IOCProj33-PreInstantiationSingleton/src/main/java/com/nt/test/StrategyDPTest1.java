package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.FirstFlight;
import com.nt.beans.Flipkart;

public class StrategyDPTest1 {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		XmlBeanDefinitionReader reader=null;
		Flipkart  fpkt=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		System.out.println("IOC container (ApplicationContext) is created");
		//get Taget Bean object
		/*fpkt=ctx.getBean("fpkt",Flipkart.class);
		//invoke the methods
		System.out.println(fpkt.shopping(new String[] {"PPEKit"," MASK","Sanitizer"},new float[] {2000,500,200}));
		System.out.println("-----------------------------");
		ctx.getBean("fFlight",FirstFlight.class); */
		
		
		
	}//main
}//class
