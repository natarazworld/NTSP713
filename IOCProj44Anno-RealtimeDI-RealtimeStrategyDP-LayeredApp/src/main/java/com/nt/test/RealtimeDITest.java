package com.nt.test;

import java.io.Closeable;
import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealtimeDITest {

	public static void main(String[] args) {
		Scanner sc = null;
		String name = null, cadd = null, pamt = null, rate = null, time = null;
		CustomerVO vo = null;
	    ApplicationContext ctx=null;
		MainController controller = null;
		String result = null;
		// read inputs
		sc = new Scanner(System.in);
		System.out.println("enter Customername :: ");
		name = sc.next();
		System.out.println("Enter customer Addrs::");
		cadd = sc.next();
		System.out.println("Enter Principle  amount::");
		pamt = sc.next();
		System.out.println("Enter rate of intrest::");
		rate = sc.next();
		System.out.println("Enter time   ::");
		time = sc.next();
		// Store inputs in VO class object
		vo = new CustomerVO();
		vo.setCname(name);
		vo.setCadd(cadd);
		vo.setpAmt(pamt);
		vo.setRate(rate);
		vo.setTime(time);
		// create BEanFacory IOC container
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Controller Bean class object..
		controller = ctx.getBean("controller", MainController.class);
		// invoke the method
		try {
			result = controller.processCustomer(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal Problem");
			e.printStackTrace();
		}
		
		//close container
		 ((AbstractApplicationContext) ctx).close();
	}// main
}// class
