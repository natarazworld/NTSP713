package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformenceMonitoringAspect {

	public Object monitor(ProceedingJoinPoint pjp)throws Throwable{
		long start=System.currentTimeMillis(); //pre logic
		Object retVal=pjp.proceed();
		long end=System.currentTimeMillis(); //post logic
		System.out.println(pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs())+" has taken"+(end-start)+" ms");
	  return retVal;
	}
}
