package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer  implements ApplicationContextAware {
	private String beanId;
	private ApplicationContext ctx;
	
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("WebContainer.setApplicationContext(-)");
		this.ctx=ctx;
	}

	public WebContainer() {
		System.out.println("WebContainer:: 0-param constructor");
	}
	
	public   void  processRequest(String data) {
		RequestHandler handler=null;
		System.out.println("WebContainer is processing request with data::"+data+ "by giving it to handler");
		//get Dependent object using dependency lookp
		handler=ctx.getBean(beanId,RequestHandler.class);
		handler.handleRequest(data);
	}
}
