package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.LoanAmtIntrestCalculator;

public class PropertyEditorTest_AC {
	public static void main(String[] args) {
		 ApplicationContext ctx=null;
		 LoanAmtIntrestCalculator  calculaor=null;
		 //create IOC contaienr
		 ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 
		 //get Spring Bean class object
		 calculaor=ctx.getBean("laiCalculator",LoanAmtIntrestCalculator.class);
		 //invoke b.method
		 System.out.println("Intrest amount::"+calculaor.calculateIntrestAmt());
		 
	}
	
}//outer class
