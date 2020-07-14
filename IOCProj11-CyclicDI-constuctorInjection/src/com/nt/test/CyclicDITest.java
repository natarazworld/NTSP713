package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.A;



public class CyclicDITest {

	public static void main(String[] args) {
		BeanFactory factory=null;
		A  a1=null;
		//create IOC container
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//get Bean
		a1=factory.getBean("a1",A.class);
		System.out.println(a1);
		
	}//main
}//class
