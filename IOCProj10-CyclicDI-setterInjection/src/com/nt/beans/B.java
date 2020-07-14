package com.nt.beans;

public class B {
	private A  a;
	
	public B() {
		System.out.println("B:: 0-param constructor");
	}

	  // alt+shift+s ,r
	public void setA(A a) {
		System.out.println("B.setA()");
		this.a = a;
	}

	  // alt+shift+s ,s
	@Override
	public String toString() {
		return "B [a=";
	}
	
	
	

}
