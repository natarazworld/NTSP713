package com.nt.aspect;

import org.aspectj.lang.JoinPoint;

import com.nt.exception.InvalidInputsException;

public class CommonExceptionGrapher extends RuntimeException {
	
	public  void exceptionGrapher(JoinPoint jp,Exception ex) {
		throw new InvalidInputsException(ex.getMessage());
	}

}
