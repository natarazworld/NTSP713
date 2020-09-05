package com.nt.beans;

import javax.inject.Named;

@Named("dtdc")
public final class DTDC implements Courier {
	
	public DTDC() {
		System.out.println("DTDC:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("DTDC.deliver()");
		return "DTDC Courier will deliver  order id :: "+oid +" order  products";
	}

}
