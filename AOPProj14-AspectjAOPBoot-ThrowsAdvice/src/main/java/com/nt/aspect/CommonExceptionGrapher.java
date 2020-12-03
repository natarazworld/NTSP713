package com.nt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.nt.exception.InvalidInputsException;

@Component("exceptionGrapher")
@Aspect
public class CommonExceptionGrapher {
	
	 @AfterThrowing(pointcut = "execution(float  com.nt.service.ShoppingStore.*(..))",throwing = "ex")
	public  void exceptionGrapher(JoinPoint jp,Exception ex) {
		throw new InvalidInputsException(ex.getMessage());
	}

}
