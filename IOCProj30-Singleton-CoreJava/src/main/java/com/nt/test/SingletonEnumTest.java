package com.nt.test;

import com.nt.sdp.Printer1;

public class SingletonEnumTest {

	public static void main(String[] args) {
		   Printer1 p1=null,p2=null;
		   
		   p1=Printer1.INSTANCE;
		   p2=Printer1.INSTANCE;
		   System.out.println(p1.hashCode()+"  "+p2.hashCode());
		   System.out.println("(p1==p2?)"+(p1==p2));
		   p1.printData("hello1");
		   p2.printData("hello2");
		   Printer1.INSTANCE.printData("hello3");
		   System.out.println(Printer1.INSTANCE.hashCode()+"  "+Printer1.INSTANCE.getClass());
		   

	}

}
