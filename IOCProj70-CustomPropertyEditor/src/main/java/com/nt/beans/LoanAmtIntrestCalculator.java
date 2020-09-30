package com.nt.beans;

public class LoanAmtIntrestCalculator {
	private  LoanAmtDetails  details;

	public LoanAmtIntrestCalculator(LoanAmtDetails details) {
		this.details = details;
	}
	
	public  float   calculateIntrestAmt() {
		return  (details.getpAmt()* details.getRate()* details.getTime())/1000.0f;
	}
	

}
