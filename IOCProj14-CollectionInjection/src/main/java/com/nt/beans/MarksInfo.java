package com.nt.beans;

import java.util.Arrays;
import java.util.Date;

public class MarksInfo {
	private int marks[];
	private Date  dates[];

	public void setDates(Date[] dates) {
		this.dates = dates;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "MarksInfo [marks=" + Arrays.toString(marks) + ", dates=" + Arrays.toString(dates) + "]";
	}

	
	
	

}
