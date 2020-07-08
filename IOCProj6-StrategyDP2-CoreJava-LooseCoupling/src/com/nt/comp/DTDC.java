package com.nt.comp;

//final -rule3
//Interface impl - rule2
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
