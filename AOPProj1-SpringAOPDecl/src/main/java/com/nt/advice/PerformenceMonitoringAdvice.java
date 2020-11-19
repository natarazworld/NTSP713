package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformenceMonitoringAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("PerformenceMonitoringAdvice.invoke() prelogic"+invocation.getClass());
		long startTime=System.currentTimeMillis(); //pre logics
		//To modify the target method arg values
		Object args[]=invocation.getArguments();
		if(((Float)args[0])<50000)
			  args[1]=((Float)args[1])-0.5f;
		
		//controlling target method execution
		if(((Float)args[0])<0 || ((Float)args[1])<0 || ((Float)args[2])<0)
			   throw new IllegalArgumentException("invalid inputs");
		Object retVal=invocation.proceed(); // invokes the target method
		
		long endTime=System.currentTimeMillis();  //post logics
		System.out.println("PerformenceMonitoringAdvice.invoke() postlogic");
		//evaluate the performence
		System.out.println(invocation.getMethod().getName()+" with args"+Arrays.toString(invocation.getArguments())+" has taken"+(endTime-startTime)+" ms");
		//modifying the retVal
		retVal=((Float)retVal)+ ((Float)retVal)*0.05f;
		return retVal;
	}//method
}//class
