package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("cacheAspect")
@Aspect
@Order(3)
public class CachingAspect {
	private Map<String,Object> cacheMap=new HashMap();

	@Around("execution(float  com.nt.service.IBankService.*(..))")
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
}//class
