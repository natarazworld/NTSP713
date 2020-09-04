package com.nt.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//final -rule3
//Interface impl - rule2
@Component("dhl")
@Lazy
public final class DHL implements Courier {
	
	public DHL() {
		System.out.println("DHL:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("DHL.deliver()");
		return "DHL Courier will deliver  order id :: "+oid +" order  products";
	}

}
