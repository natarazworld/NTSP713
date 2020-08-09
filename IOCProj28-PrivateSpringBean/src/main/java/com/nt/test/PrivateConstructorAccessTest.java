package com.nt.test;

import java.lang.reflect.Constructor;
import com.nt.beans.TestBean;

public class PrivateConstructorAccessTest {

	public static void main(String[] args) {
		Class c=null;
		Constructor cons[]=null;
		TestBean tb1=null,tb2=null;
		try {
			 //Load the class
			c=Class.forName("com.nt.beans.TestBean");
			//get Access to all the cosntructors of the class..
			cons=c.getDeclaredConstructors();
			//create objects
			cons[0].setAccessible(true);
			 tb1=(TestBean)cons[0].newInstance();
			System.out.println(tb1);
			System.out.println("---------------------------------");
			cons[1].setAccessible(true);
			tb2=(TestBean)cons[1].newInstance(10,20);
			System.out.println(tb2);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
