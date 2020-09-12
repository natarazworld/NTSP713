package com.nt.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("engg")
public class Engine {
	
	public Engine() {
		System.out.println("Engine:: 0-param constructor");
	}
	
	public  void start() {
		System.out.println("Engine.start()--->Engine started");
	}
	
	public  void stop() {
		System.out.println("Engine: stop()--->Engine stopped");
	}
	

}
