//ShoppingStore.java (target class)
package com.nt.service;

import org.springframework.stereotype.Service;

@Service("shopping")
public class ShoppingStore {

	public  float   shopping(String items[], float prices[]) {
		float billAmt=0.0f;
		 for(float p:prices) 
			  billAmt=billAmt+p;
		 return  billAmt;
	}
	
}
