package com.nt.sdp;

public enum Printer1 {
    INSTANCE;   //by default enum constants  are  public static  final of Type Enum class
                         // internally public static final Printer1 INSTANCE=new Printer1();
  //b.method
  public void  printData(String msg) {
	  System.out.println(msg);
  }

}
