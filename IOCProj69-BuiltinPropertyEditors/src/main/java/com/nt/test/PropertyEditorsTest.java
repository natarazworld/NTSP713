package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PersonInfo;

public class PropertyEditorsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PersonInfo info=null;
		//create IOC contaienr
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean object
		info=ctx.getBean("pInfo",PersonInfo.class);
		System.out.println(info);
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
