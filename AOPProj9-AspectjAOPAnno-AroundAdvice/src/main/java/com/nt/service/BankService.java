package com.nt.service;

import org.springframework.stereotype.Service;

@Service("bankService")
public  class BankService {

	public  float  calculateSimpleIntrestAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calculateSimpleIntrestAmount(-,-,-)[target method]");
		return  pAmt*rate*time/100.0f;
	}
	
	public  float  calculateCompoundIntrestAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calculateCompoundIntrestAmount(-,-,-)[target method]");
		return    (float) ((pAmt* Math.pow(1+rate/100,time)))-pAmt;   //     p(1+r/100)^t-p
	}
	
	
}
