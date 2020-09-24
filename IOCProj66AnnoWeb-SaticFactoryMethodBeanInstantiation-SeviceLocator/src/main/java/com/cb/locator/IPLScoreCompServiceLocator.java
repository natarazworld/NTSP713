package com.cb.locator;



import com.ipl.external.IIPLScoreComp;
import com.ipl.external.IPLScoreCompImpl;


public interface IPLScoreCompServiceLocator  {
     final static IIPLScoreComp  extComp=new IPLScoreCompImpl();   //eager instantatiation..
	
	public static IIPLScoreComp  getExtComp() { 
		return extComp;
	}
}
