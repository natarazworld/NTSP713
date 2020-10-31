package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.IBankMgmtService;

public class MappingSQLOperationsTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		IBankMgmtService service=ctx.getBean("bankService",IBankMgmtService.class);
		//invoke methods
		try {
			System.out.println("BankAcounts having balance range 10000 to 100000");
			service.fetchBankAccountsBySalRange(10000, 100000).forEach(System.out::println);
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("--------------------------------------------------");
		try {
			System.out.println("1447 bank account details ::"+service.fetchBankAccountByAcno(1447));
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("-------------------------------------------");
		try {
			System.out.println(service.addBonusToAccountsByBalance(1000,10000));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
