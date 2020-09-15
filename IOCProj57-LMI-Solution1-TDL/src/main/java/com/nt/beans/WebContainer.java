package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer {
	private String beanId;
	
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public WebContainer() {
		System.out.println("WebContainer:: 0-param constructor");
	}
	
	
	
	public   void  processRequest(String data) {
		ApplicationContext ctx=null;
		RequestHandler handler=null;
		System.out.println("WebContainer is processing request with data::"+data+ "by giving it to handler");
		//create Extra IOC cotainer
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Dependent object using dependency lookp
		handler=ctx.getBean(beanId,RequestHandler.class);
		handler.handleRequest(data);
	}

}
