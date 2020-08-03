package com.nt.beans;

public class ProffesionalCrickter {
	private  CricketBat  bat;
	private String  name;

	public ProffesionalCrickter(String name,CricketBat bat) {
		System.out.println("ProffesionalCrickter::2-param constructor");
		this.name=name;
		this.bat = bat;
	}
	
	public  String batting() {
		int runs=0;
		runs=bat.scoreRuns();
		return "Batsman::"+name+"  has scored :: "+runs +"  runs"; 
	}

}
