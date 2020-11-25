package com.nt.service;

public interface IBankService {
	public  float  calculateSimpleIntrestAmount(float pAmt,float rate,float time);
	public  float  calculateCompoundIntrestAmount(float pAmt,float rate,float time);
}
