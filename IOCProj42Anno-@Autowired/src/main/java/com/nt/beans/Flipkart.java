package com.nt.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
 //final --rule3
public final class Flipkart {
	//property
	//@Autowired
	//@Qualifier("bDart")
	//@Qualifier("d1")
	private  Courier courier;  //rule1 ,2
	//@Autowired
	private  Date  sysDate;
	
	
	/*@Autowired(required = true)
	public Flipkart() {
		System.out.println("Flipkart:: 0-param constructor");
	}*/
	
	
	/*	@Autowired(required =false)
		public Flipkart(@Qualifier("bDart") Courier courier,Date  sysDate) {
			 this.courier=courier;
			 this.sysDate=sysDate;
			System.out.println("Flipkart:: 2-param constructor");
		}*/
	
	
	
	/*@Autowired(required =false)
	public Flipkart(Date sysDate) {
		 this.sysDate=sysDate;
		System.out.println("Flipkart:: 1-param constructor");
	}
	
	@Autowired(required =false)
	public Flipkart(@Qualifier("dtdc") Courier courier) {
		 this.courier=courier;
		System.out.println("Flipkart:: 1-param constructor");
	}*/
	
	
	
	
	
	
	
	
	
	
/*	@Autowired
	@Qualifier("fFlight")
	public   void  assign(Courier courier) {
		System.out.println("Flipkart.assign(-)");
		this.courier=courier;
	}*/
	
	/*@Autowired
	@Qualifier("dhl")
	public void  setCourier(Courier courier ) {
		System.out.println("Flipkart.setCourier(-)");
		this.courier=courier;
	}
	
	@Autowired
	public void setSysDate(Date date) {
		System.out.println("Flipkart.setSysDate(-)");
		this.sysDate=date;
	}*/
	
	
		
	//b.method
	public  String  shopping(String[] items,float[] prices) {
		System.out.println("Flipkart.shopping():::"+sysDate);
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
