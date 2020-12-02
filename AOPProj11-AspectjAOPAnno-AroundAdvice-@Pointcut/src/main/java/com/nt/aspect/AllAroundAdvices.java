package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("allAround")
@Aspect
public class AllAroundAdvices {
	
	@Pointcut("execution(float  com.nt.service.IBankService.*(..))")
	public  void myPtc() {  //dummy method
		
	}

	@Around("myPtc()")
	@Order(100)
	public  Object  logging(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("Entering into "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		System.out.println("logAdvcie(before)");
		Object retVal=pjp.proceed();
		System.out.println("logAdvcie(after)");
		System.out.println("Leaving "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		return retVal;
	}
	
	private Map<String,Object> cacheMap=new HashMap();
	@Around("myPtc()")
	@Order(20)
	public Object   caching(ProceedingJoinPoint pjp)throws Throwable{
		//prepare the key having methodname and arg value
		String key=pjp.getSignature()+Arrays.toString(pjp.getArgs());
		
		Object retVal=null;
		if(!cacheMap.containsKey(key)) {  //if key not there in the cacheMap
			System.out.println("from target method");
			System.out.println("cacheAdvcie(before)");
			retVal=pjp.proceed(); //invokes the target method
			System.out.println("cacheAdvcie(after)");
			cacheMap.put(key,retVal);  //put the results in cacheMap
		}
		else {
			retVal=cacheMap.get(key);
			System.out.println("from cache");
		}
		
		return  retVal;
	}//method
	
	@Around("myPtc()")
	@Order(200)
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
