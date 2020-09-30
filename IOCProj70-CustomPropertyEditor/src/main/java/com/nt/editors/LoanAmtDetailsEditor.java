package com.nt.editors;

import java.beans.PropertyEditorSupport;

import com.nt.beans.LoanAmtDetails;

public class LoanAmtDetailsEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("LoanAmtDetailsEditor.setAsText()");
		float pAmt=0.0f,rate=0.0f,time=0.0f;
		String info[]=null;
		LoanAmtDetails  details;
		//spilt text into pAmt,rate,time
		/*pAmt=Float.parseFloat(text.substring(0,text.indexOf(",")));  //gvies  1000000
		rate=Float.parseFloat(text.substring(text.indexOf(",")+1, text.lastIndexOf(",")));  //gives 2
		time=Float.parseFloat(text.substring(text.lastIndexOf(",")+1,text.length()));  //gives 10
		*/
		info=text.split(",");
		pAmt=Float.parseFloat(info[0]);
		rate=Float.parseFloat(info[1]);
		time=Float.parseFloat(info[2]);
		//create  LoanAmtDetails object
		details=new LoanAmtDetails();
		details.setpAmt(pAmt); details.setRate(rate); details.setTime(time);
		//set details object to  Bean property as value
		setValue(details);
	}

}
