package com.nt.test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringI18nTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Locale locale=null;
		String cap1=null,cap2=null,cap3=null,cap4=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//prepare Locale object
		locale=new  Locale(args[0],args[1]); //args[0] ->language  , args[1] -> country
		//get Messages
		cap1=ctx.getMessage("btn1.cap", new String[] {"student"} ,"msg1", locale);
		cap2=ctx.getMessage("btn2.cap", null, "msg2",locale);
		cap3=ctx.getMessage("btn3.cap", null, "msg3",locale);
		cap4=ctx.getMessage("btn4.cap", null,"msg4", locale);
		System.out.println(cap1+"   "+cap2+"   "+cap3+"   "+cap4);
		System.out.println(ctx.getMessage("btn2.cap", null, new Locale("de","DE")));
		System.out.println(ctx.getMessage("btn2.cap", null, new Locale("hi","IN")));
		System.out.println(ctx.getMessage("btn2.cap", null, new Locale("x","y")));
		
		
	}
}
// To run the App having cmd line args from eclipse 
// runas ---> run cfgs ---> arguments tab ---> program arguments--->  pass  locale info  like   fr    Fr  ---> apply--> run ..


