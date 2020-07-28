package com.nt.beans;

import java.util.Date;
import java.util.List;

public class College {
	private List<String>  studNames;
	private  List<Date>  datesList;
	
	public void setStudNames(List<String> studNames) {
		this.studNames = studNames;
	}
	public void setDatesList(List<Date> datesList) {
		System.out.println(datesList.getClass());
		this.datesList = datesList;
	}
	
	@Override
	public String toString() {
		return "College [studNames=" + studNames + ", datesList=" + datesList + "]";
	}
	
	

}
