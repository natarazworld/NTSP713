package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Engine;
import com.nt.beans.Vehicle;

public class DependencyLookupTest {

	public static void main(String[] args) {
		  //create IOC container 
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Vehicle vehicle=null;
		//create  IOC Container 
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		System.out.println("1 st container");
		//get Target class object
		vehicle=factory.getBean("vehicle",Vehicle.class);
		//invoke methods
		vehicle.journey("hyd","warangal");
		vehicle.entertainment();
		vehicle.soundHorn();
		vehicle.fillFuel();
		

	}

}
