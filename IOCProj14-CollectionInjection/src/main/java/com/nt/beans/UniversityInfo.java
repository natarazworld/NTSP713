package com.nt.beans;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class UniversityInfo {
	private Map<Integer,String>  facultyDetails;
	private Map<String,Date>  datesInfo;
	private Properties  fruitsInfo;
	
	public void setFruitsInfo(Properties fruitsInfo) {
		this.fruitsInfo = fruitsInfo;
	}
	public void setFacultyDetails(Map<Integer, String> facultyDetails) {
		System.out.println(facultyDetails.getClass());
		this.facultyDetails = facultyDetails;
	}
	public void setDatesInfo(Map<String, Date> datesInfo) {
		this.datesInfo = datesInfo;
	}
	
	@Override
	public String toString() {
		return "UniversityInfo [facultyDetails=" + facultyDetails + ", datesInfo=" + datesInfo + ", fruitsInfo="
				+ fruitsInfo + "]";
	}
	
	
	
	

}
