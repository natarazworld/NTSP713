package com.nt.aspect;

import java.io.FileWriter;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;

public class TestDriveAuditAspect {

	/*public  void testDrive(JoinPoint jp)throws Throwable{
		//get target metod args
		Object args[]=jp.getArgs();
		//write info to  audit log file
		FileWriter writer=new FileWriter("E:/auditLog.txt",true);  // true :: To open the file in append mode
		writer.write(args[0]+" model car test drive is taken under the monitoring of "+args[2]+" executive at "+LocalDateTime.now()+"\n");
		writer.flush();
		writer.close();
		
	}*/
	
	/*public  void testDrive(JoinPoint jp,String model,float price,String executive)throws Throwable{
		//write info to  audit log file
		FileWriter writer=new FileWriter("E:/auditLog.txt",true);  // true :: To open the file in append mode
		writer.write(model+" model car test drive is taken under the monitoring of "+executive+" executive at "+LocalDateTime.now()+"\n");
		writer.flush();
		writer.close();
	}*/
	
	public  void testDrive(String model,float price,String executive)throws Throwable{
		System.out.println("TestDriveAuditAspect.testDrive()");
		//write info to  audit log file
		FileWriter writer=new FileWriter("E:/auditLog.txt",true);  // true :: To open the file in append mode
		writer.write(model+" model car test drive is taken under the monitoring of "+executive+" executive at "+LocalDateTime.now()+"\n");
		writer.flush();
		writer.close();
	}
}
