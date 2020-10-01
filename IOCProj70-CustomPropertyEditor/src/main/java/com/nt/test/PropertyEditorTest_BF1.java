package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.LoanAmtDetails;
import com.nt.beans.LoanAmtIntrestCalculator;
import com.nt.editors.LoanAmtDetailsEditor;

public class PropertyEditorTest_BF1 {
	public static void main(String[] args) {
		 DefaultListableBeanFactory factory=null;
		 XmlBeanDefinitionReader reader=null;
		 LoanAmtIntrestCalculator  calculaor=null;
		  
		 
		 //create IOC container
		 factory=new DefaultListableBeanFactory();
		 reader=new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		 //add CustomPropertyEditorRegistrar  to IOC container
		 factory.addPropertyEditorRegistrar(new PropertyEditorRegistrar() {
			@Override
			public void registerCustomEditors(PropertyEditorRegistry registry) {
				registry.registerCustomEditor(LoanAmtDetails.class, new LoanAmtDetailsEditor());
			}  //method
		}// anonymous inner class
		 );
		 //get Spring Bean class object
		 calculaor=factory.getBean("laiCalculator",LoanAmtIntrestCalculator.class);
		 //invoke b.method
		 System.out.println("Intrest amount::"+calculaor.calculateIntrestAmt());
		 
	}
	
}//outer class
