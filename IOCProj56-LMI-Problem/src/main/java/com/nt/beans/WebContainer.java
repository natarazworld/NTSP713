package com.nt.beans;

public class WebContainer {
	private  RequestHandler rh;
	
	public WebContainer() {
		System.out.println("WebContainer:: 0-param constructor");
	}
	
	public    void setRh(RequestHandler rh) {
		this.rh=rh;
	}
	
	public   void  processRequest(String data) {
		System.out.println("WebContainer is processing request with data::"+data+ "by giving it to handler");
		rh.handleRequest(data);
	}

}
