package com.nt.sdp;

public class Printer {
  private  static Printer  INSTANCE;
  
  //private constructor
  private  Printer() {
	  System.out.println("Printer:: 0-param cosnstructor");
  }
  
  //static  factory method
  public  static Printer getInstance() {
	    if(INSTANCE==null)
	    	INSTANCE=new Printer();
	    return INSTANCE;
  }
  
  //b.method
  public void  printData(String msg) {
	  System.out.println(msg);
  }

}
