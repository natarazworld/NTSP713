package com.nt.beans;

import java.time.LocalDate;

public class ScheduleRemainder {
	private      LocalDate date;
	
	public ScheduleRemainder(LocalDate date) {
		System.out.println("ScheduleRemainder:: 1-param constructor");
		 this.date=date;
	}
	
	public    String remainder() {
		LocalDate sysDate=null;
		//get System date
		sysDate=LocalDate.now();
		if(sysDate.isEqual(date))
     		return "Reamainder about   Attending  board meetting";
		else
			return "Today no appointments... Relax ... and rest";
	}
	

}
