package com.nt.service;

public final   class BankServiceImpl implements BankService{
       public final  float  calcSimpleIntrestAmount(float pAmt,float rate,float time) {
    	   System.out.println("BankService.calcSimpleIntrestAmount()");
    	   return pAmt*rate*time/100.0f;
       }
}
