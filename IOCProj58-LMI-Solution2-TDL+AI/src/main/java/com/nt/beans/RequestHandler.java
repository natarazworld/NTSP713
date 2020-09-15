package com.nt.beans;

public class RequestHandler {
    private  static int count;
    
    public RequestHandler() {
    	count++;
		System.out.println("RequestHandler:: 0-param consturctor ::::"+count);
	}
    
    public  void handleRequest(String  data) {
    	System.out.println("handling request with "+data +"using the object ::"+count);
    }
    
}
