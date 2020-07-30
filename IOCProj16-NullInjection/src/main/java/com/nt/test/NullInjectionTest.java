package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.PersonInfo;

public class NullInjectionTest {
	  public static void main(String[] args) {
		  DefaultListableBeanFactory factory=null;
		  XmlBeanDefinitionReader reader=null;
		  PersonInfo raja=null, ravi=null;
		   //create IOC container
		  factory=new DefaultListableBeanFactory();
		  reader=new XmlBeanDefinitionReader(factory);
		  reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		  //get Beans
		  raja=factory.getBean("rajaInfo",PersonInfo.class);
		  System.out.println(raja);
		  System.out.println("-----------------------------------------");
		  ravi=factory.getBean("raviInfo",PersonInfo.class);
		  System.out.println(ravi);
		  
	}

}
