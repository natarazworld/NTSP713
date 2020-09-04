package com.nt.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("fFlight")
@Lazy(true)
public class FirstFlight implements Courier {
	
	public FirstFlight() {
		System.out.println("FirstFlight:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("FirstFlight.deliver()");
		return "FirstFlight Courier will deliver  order id :: "+oid +" order  products";
	}

}
