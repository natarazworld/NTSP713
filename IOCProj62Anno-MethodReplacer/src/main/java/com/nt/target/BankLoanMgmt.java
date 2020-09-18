package com.nt.target;

import java.util.Random;

public  class BankLoanMgmt {
	
	public   float    calculateIntrestAmount(float pAmt,float rate,float time) {
		  System.out.println("BankLoanMgmt.calculateIntrestAmount() ::: compound Intrest Amount");
		  return  (float)(pAmt*Math.pow(1+rate/100, time))-pAmt;
	}

}
