package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.WishMessageGenerator;
import com.nt.sdp.Printer;

public class BeanScopesTest {

	public static void main(String[] args) {
		System.out.println("SetterInjectionTest.main()");
		 DefaultListableBeanFactory factory=null;
		 XmlBeanDefinitionReader reader=null;
		 WishMessageGenerator generator=null,generator1=null,generator2=null;
		 WishMessageGenerator gen1=null,gen2=null,gen3=null;
		 Printer p1=null,p2=null;
		 
		 //create IOC container
		 factory=new DefaultListableBeanFactory();
		 reader=new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		 //get Target bean class object
		 generator=factory.getBean("wmg",WishMessageGenerator.class);
		 generator1=factory.getBean("wmg",WishMessageGenerator.class);
		 generator2=factory.getBean("wmg",WishMessageGenerator.class);
		 System.out.println(generator.hashCode()+"  "+generator1.hashCode()+"  "+generator2.hashCode());
		 System.out.println("generrator==generator1?"+(generator==generator1));
		 System.out.println("generrator1==generator2?"+(generator1==generator2));
		 System.out.println("generrator==generator2?"+(generator==generator2));
		 
		 System.out.println("...........................................................................");
		 p1=factory.getBean("p1",Printer.class);
		 p1.printData("hello");
		 p2=factory.getBean("p1",Printer.class);
		 p2.printData("hai");
		 System.out.println(p1.hashCode()+"  "+p2.hashCode());
		 
		
		 
		 
		 
				
	}//main
}//class
