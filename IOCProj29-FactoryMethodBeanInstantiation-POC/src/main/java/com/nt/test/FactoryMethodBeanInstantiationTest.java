package com.nt.test;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Properties;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class FactoryMethodBeanInstantiationTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Class c1=null;
		Calendar cal=null;
		Connection con=null;
		Properties props=null;
		String str2=null;
		String str3=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean
		c1=factory.getBean("c1",Class.class);
		System.out.println("c1 obj class name"+c1.getClass().getName()+"  c1 obj data::"+c1.toString());
		System.out.println("..............................................................");
		cal=factory.getBean("cal1",Calendar.class);
		System.out.println("cal obj class name::"+cal.getClass().getName()+" cal obj data::"+cal.toString());
		System.out.println("..............................................................");
       con=factory.getBean("con",Connection.class);
       System.out.println("con obj class name::"+con.getClass().getName()+" con obj data::"+con.toString());
       
       System.out.println("..............................................................");
       props=factory.getBean("sys",Properties.class);
       System.out.println("props obj class name::"+props.getClass().getName()+" props obj data::"+props.toString());
       
       System.out.println("..............................................................");
       str2=factory.getBean("s2",String.class);
       System.out.println("str2 obj class name::"+str2.getClass().getName()+" str2 obj data::"+str2.toString());
       
       System.out.println("..............................................................");
       str3=factory.getBean("s3",String.class);
       System.out.println("str3 obj class name::"+str3.getClass().getName()+" str3 obj data::"+str3.toString());
       
       
	}

}
