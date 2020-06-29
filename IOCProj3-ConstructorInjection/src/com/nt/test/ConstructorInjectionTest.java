package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		Resource res=null;
		BeanFactory factory=null;
		WishMessageGenerator generator=null;
		// Hold spring bean cfg file name and location
		res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//create IOC container
		factory=new XmlBeanFactory(res);
		//get target bean class object
		generator=(WishMessageGenerator)factory.getBean("wmg");
		//invoke the b.method
		System.out.println(generator.generateWishMessage("raja"));
	}//main
}//class
