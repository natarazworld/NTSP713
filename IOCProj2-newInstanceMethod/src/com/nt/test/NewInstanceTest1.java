package com.nt.test;

public class NewInstanceTest1 {
	public static void main(String[] args) {
		Class c1=null,c2=null;
		Object obj1=null,obj2=null;
		try {
		   //Load the class
		c1=Class.forName(args[0]);
		//instantiate the loaded class
		obj1=c1.newInstance();
		System.out.println(obj1);
		System.out.println(".....................................................................");
		//Load the class
		c2=Class.forName(args[1]);
		//instantiate the loaded class
		obj2=c2.newInstance();
		System.out.println(obj2);
		}//try
		catch(InstantiationException ie) {
			ie.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
