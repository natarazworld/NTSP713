package com.nt.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;


@Named("fpkt")
public final class Flipkart {
	//property
	@Resource
	@Qualifier("dtdc")
	private  Courier courier;  //rule1 ,2
	@Resource
	private   Date date;
	
	
	public Flipkart() {
		System.out.println("Flipkart:: 0-param constructor");
	}
			
	//b.method
	public  String  shopping(String[] items,float[] prices) {
		System.out.println("Flipkart.shopping()::: "+date);
		 float billAmt=0.0f;
		 int oid=0;
		 String msg=null;
		 Random rad=null;
		//calculate  bill Amount
		 
		 for(float p:prices) 
			// billAmt=billAmt+p;
			 billAmt+=p;
		 //generate  order id dynamically as random number
		 rad=new Random();
		 oid= rad.nextInt(10000);
		 // use courier service for delivering the  products
		 msg=courier.deliver(oid);
		 // retrun bill Amt and courier details to customer
		return  Arrays.toString(items)+" are purchased  having prices "+Arrays.toString(prices)+"  with bill amount"+billAmt+ "----"+ msg;
	}

}
