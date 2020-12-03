//CommonExceptionLogger.java (Aspect class)
package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("exceptionLogger")
@Aspect
public class CommonExceptionLogger {
	
	
  @AfterThrowing(pointcut = "execution(float  com.nt.service.ShoppingStore.*(..))",throwing = "ex")
	public void exceptionLogger(JoinPoint jp,Exception ex) {
		System.out.println(jp.getClass());
	     System.out.println(ex+" exception is raised in "+jp.getSignature()+" having args"+Arrays.deepToString(jp.getArgs()));
	}
	
	
}
