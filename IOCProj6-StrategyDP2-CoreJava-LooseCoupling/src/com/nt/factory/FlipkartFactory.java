package com.nt.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.nt.comp.BlueDart;
import com.nt.comp.Courier;
import com.nt.comp.DTDC;
import com.nt.comp.FirstFlight;
import com.nt.comp.Flipkart;

public class FlipkartFactory {
	private static Properties props;
	static{
		InputStream is=null;
		try {
			//Locate Properties using streams
			is=new FileInputStream("src/com/nt/commons/info.properties");
			//Load Properties file into java.util.Properties object
			props=new Properties();
			props.load(is);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//stati block
	
	//Factory method
	public    static  Flipkart   getInstance()throws Exception {
		  Courier courier=null;
		  Flipkart fpkt=null;
		  //get Dependent class  and create  class object 
		   courier=(Courier) Class.forName(props.getProperty("sdp.dependent")).newInstance();  
		  //create Target class object
		  fpkt=new Flipkart();
		  //assign depedent class object to taget class object
		  fpkt.setCourier(courier);
		  return  fpkt;
	}//method

}//class
