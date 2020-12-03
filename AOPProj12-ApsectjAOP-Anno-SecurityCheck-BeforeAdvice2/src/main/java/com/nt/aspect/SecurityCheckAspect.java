package com.nt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.manager.AuthenticationManager;

@Component("securityAspect")
@Aspect
public class SecurityCheckAspect {
	@Autowired
	private AuthenticationManager manager;

	@Before("execution(java.lang.String com.nt.service.BankServiceImpl.*(..))")
	public  void  check(JoinPoint jp)throws Throwable{
		if(!manager.validate())
			  throw new IllegalArgumentException("Bad/Invalid Credentials");
	}//method
}//class
