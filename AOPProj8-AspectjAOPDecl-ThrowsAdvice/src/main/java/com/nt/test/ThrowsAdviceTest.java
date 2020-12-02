//ThrowAdviceTest.java (ClientApp)
package com.nt.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.aspect.CommonExceptionLogger;
import com.nt.service.ShoppingStore;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		//create IOC contaier
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy class obj
		ShoppingStore proxy=ctx.getBean("shopping",ShoppingStore.class);
		//invoke methods
		try {
			System.out.println("Bill Amount::"+proxy.generateBill(new String[] {"X-MaxTree","cake","Star light","bells"},
					                                                                                       new float[] {5000,1000,3000,0}));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
       //close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
