package com.nt.beans;
//final -rule3
// Interface impl - rule2
public final class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");
		return "BlueDart Courier will deliver  order id :: "+oid +" order  products";
	}

}
