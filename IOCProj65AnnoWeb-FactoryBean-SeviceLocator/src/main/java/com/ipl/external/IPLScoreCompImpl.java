package com.ipl.external;

public class IPLScoreCompImpl implements IIPLScoreComp {

	@Override
	public String getScore(int mid) {
		  if(mid==1001)
			    return   "CSK  vs MI ::  162/9 (MI), CSK (167)  CSK won by  5 wickets ";
		  else if(mid==1002)
			  return   "DC  vs KIXP ::  154/8 (DC),  XIXP (154/6)  DC won through Super over ";
		  else  if(mid==1003)
			  return   "RCB  vs SRH ::  163/8 (RCB),  SRH (153/10)  RCB won by 10 runs ";
		  else 
			   throw new IllegalArgumentException("Invalid match id");
	}

}
