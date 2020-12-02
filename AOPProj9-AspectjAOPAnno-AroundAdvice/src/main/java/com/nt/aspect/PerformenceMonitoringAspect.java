package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("pmAspect")
@Aspect
@Order(10)
public class PerformenceMonitoringAspect {
	
	@Around("execution(float  com.nt.service.BankService.*(..))")
	public   Object monitor(ProceedingJoinPoint pjp)throws Throwable{
		long start=System.currentTimeMillis();
		System.out.println("pmAdvcie(before)");
		Object retVal=pjp.proceed();
		long end=System.currentTimeMillis();
		System.out.println("pmAdvcie(after)");
		System.out.println(pjp.getSignature()+" with args "+Arrays.deepToString(pjp.getArgs())+" has taken "+(end-start)+" ms");
		return retVal;
	}

}
