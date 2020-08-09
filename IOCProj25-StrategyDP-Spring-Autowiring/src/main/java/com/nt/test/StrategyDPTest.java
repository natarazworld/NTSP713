package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;

import com.nt.comp.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		Resource res=null;
		Flipkart  fpkt=null,fpkt1=null;
		XmlBeanDefinitionReader reader=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Taget Bean object
		fpkt=factory.getBean("fpkt",Flipkart.class);
		try{
		//invoke the methods
		System.out.println(fpkt.shopping(new String[] {"PPEKit"," MASK","Sanitizer"},new float[] {2000,500,200}));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		/*System.out.println("..................................");
		fpkt1=factory.getBean("fpkt1",Flipkart.class);
		try{
			//invoke the methods
			System.out.println(fpkt1.shopping(new String[] {"PPEKit1"," MASK1","Sanitizer1"},new float[] {200,50,20}));
			}
			catch (Exception e) {
				e.printStackTrace();
			}*/
	}//main
}//class
