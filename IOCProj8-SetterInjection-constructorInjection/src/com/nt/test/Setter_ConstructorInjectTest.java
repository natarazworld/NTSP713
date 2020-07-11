package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.comp.Student;

public class Setter_ConstructorInjectTest {

	public static void main(String[] args) {
		BeanFactory factory=null;
		Student stud=null;
		//create IOC container
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//get  spring bean class object
		stud=factory.getBean("stud",Student.class);
		System.out.println(stud);
		

	}

}
