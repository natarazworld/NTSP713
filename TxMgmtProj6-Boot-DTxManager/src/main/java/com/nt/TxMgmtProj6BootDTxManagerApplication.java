package com.nt;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IBankServiceMgmt;

@SpringBootApplication
public class TxMgmtProj6BootDTxManagerApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(TxMgmtProj6BootDTxManagerApplication.class, args);
		//get Proxy object
		IBankServiceMgmt proxy=ctx.getBean("bankService",IBankServiceMgmt.class);
		//invoke b.method
		try {
			System.out.println(proxy.transferMoney(1005, 1002, 1500));
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
