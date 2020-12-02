//CommonExceptionLogger.java (Aspect class)
package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class CommonExceptionLogger {
	
	public void exceptionLogger(IllegalArgumentException ex) {
	     System.out.println(ex+" exception is raised (extact match) ");
	}
	
	
	public void exceptionLogger(Exception ex) {
	     System.out.println(ex+" exception is raised ");
	}
	
	public void exceptionLogger(JoinPoint jp,Exception ex) {
		System.out.println(jp.getClass());
	     System.out.println(ex+" exception is raised in "+jp.getSignature()+" having args"+Arrays.deepToString(jp.getArgs()));
	}
	
	
}
