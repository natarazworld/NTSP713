package com.nt.test;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.LoanAmtIntrestCalculator;

public class PropertyEditorTest_BF3 {
	public static void main(String[] args) {
		 DefaultListableBeanFactory factory=null;
		 XmlBeanDefinitionReader reader=null;
		 LoanAmtIntrestCalculator  calculaor=null;
		  CustomEditorConfigurer cec=null;
		 
		 //create IOC container
		 factory=new DefaultListableBeanFactory();
		 reader=new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		  //get CustomEditorConfigure object
		     cec=factory.getBean(CustomEditorConfigurer.class);
		     cec.postProcessBeanFactory(factory);
		 //get Spring Bean class object
		 calculaor=factory.getBean("laiCalculator",LoanAmtIntrestCalculator.class);
		 //invoke b.method
		 System.out.println("Intrest amount::"+calculaor.calculateIntrestAmt());
		 
	}
	
}//outer class
