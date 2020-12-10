package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IBankMgmtService;

@SpringBootApplication
public class TxMgmtProj4BootLocalTxMgmtDsTxMgmrApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(TxMgmtProj4BootLocalTxMgmtDsTxMgmrApplication.class, args);
		//get Proxy class obj
		IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
		//invoke b.method
		try {
			if(proxy.transferMoney(1002,1005, 1000))
				System.out.println("Money transffered");
			else
				System.out.println("Money not transffered");
		}
		catch(Exception e) {
			System.out.println("Problem in Money Transffering");
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class
