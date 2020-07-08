package com.nt.comp;

import java.util.Arrays;
import java.util.Random;
 //final --rule3
public final class Flipkart {
	//property
	private  Courier courier;  //rule1 ,2
	
	public Flipkart() {
		System.out.println("Flipkart:: 0-param constructor");
	}

	public void setCourier(Courier courier) {   //rule2
		System.out.println("Flipkart.setCourier()");
		this.courier = courier;
	} 
	
	//b.method
	public  String  shopping(String[] items,float[] prices) {
		System.out.println("Flipkart.shopping()");
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
