package com.nt.beans;

public class Marks {
	private int m1,m2,m3;

	public Marks(int m1, int m2, int m3) {
		System.out.println("Marks: 3-param constructor");
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}

	@Override
	public String toString() {
		return "Marks [m1=" + m1 + ", m2=" + m2 + ", m3=" + m3 + "]";
	}
	
	
	
	

	}
