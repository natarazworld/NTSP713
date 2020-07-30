package com.nt.beans;

import java.util.Date;

public class PersonInfo {
	private long ano;
	private String name;
	private  Date  dob;
	private  Date  dom;
	private  Date  doj;
	
	public PersonInfo(long ano, String name, Date dob, Date dom, Date doj) {
		System.out.println("PersonInfo:: 5-param constructor");
		this.ano = ano;
		this.name = name;
		this.dob = dob;
		this.dom = dom;
		this.doj = doj;
	}
	
	
	@Override
	public String toString() {
		return "PersonInfo [ano=" + ano + ", name=" + name + ", dob=" + dob + ", dom=" + dom + ", doj=" + doj + "]";
	}
	
	

}
