package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.IBankMgmtService;

public class TxMgmtTest {

	public static void main(String[] args) {
		//create IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Proxy object
		IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
		System.out.println(proxy.getClass());
		//invoke b.method
		try {
			if(proxy.transferMoney(1002, 1006, 2000.0))
				  System.out.println("Money Transfered");
			else
				System.out.println("Problem in momeny  transffering");
		}
		catch(Exception e) {
			System.out.println("Money not transffered");
			e.printStackTrace();
		}
        //close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
