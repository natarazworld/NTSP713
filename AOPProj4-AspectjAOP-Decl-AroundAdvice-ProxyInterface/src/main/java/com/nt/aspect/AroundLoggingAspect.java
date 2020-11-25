package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundLoggingAspect {
	
	  JoinPoint 
	public  Object  logging(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("Entering into "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		Object retVal=pjp.proceed();
		System.out.println("Leaving "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		return retVal;
	}

}
