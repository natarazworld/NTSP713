package com.nt.aspect;

import java.io.FileWriter;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("cuponAdvice")
@Aspect
public class DiscountCuponAdvice {
	
	/*public  void   cupon(JoinPoint jp, float billAmt)throws Throwable{
		  String  cuponMsg=null;
		//generate  Cupon message
		  if(billAmt<10000)
			   cuponMsg=" Avail 5% Discount  on the next Purcahse";
		  else if(billAmt<20000)
			  cuponMsg=" Avail 10% Discount  on the next Purcahse";
		  else if(billAmt<30000)
		         cuponMsg=" Avail 15% Discount  on the next Purcahse";
		  else
			   cuponMsg=" Avail 20% Discount  on the next Purcahse";
		  //generate  Cupon
		  FileWriter writer=new  FileWriter("F:/cupon.txt");
		  writer.write(cuponMsg);
		  writer.flush();
		  writer.close();
		  
	}*/
	
	@AfterReturning(pointcut = "execution(float   com.nt.service.ShoppingStore.shopping(..))",returning = "billAmt")
	public  void   cupon( float billAmt)throws Throwable{
		  String  cuponMsg=null;
		//generate  Cupon message
		  if(billAmt<10000)
			   cuponMsg=" Avail 5% Discount  on the next Purcahse";
		  else if(billAmt<20000)
			  cuponMsg=" Avail 10% Discount  on the next Purcahse";
		  else if(billAmt<30000)
		         cuponMsg=" Avail 15% Discount  on the next Purcahse";
		  else
			   cuponMsg=" Avail 20% Discount  on the next Purcahse";
		  //generate  Cupon
		  FileWriter writer=new  FileWriter("F:/cupon.txt");
		  writer.write(cuponMsg);
		  writer.flush();
		  writer.close();
		  
	}

}
