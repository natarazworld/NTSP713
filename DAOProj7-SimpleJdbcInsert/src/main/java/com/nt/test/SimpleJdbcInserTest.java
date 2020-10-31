package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.BankAccountDTO;
import com.nt.service.IBankAccountMgmtService;

public class SimpleJdbcInserTest {

	public static void main(String[] args) {
		
	//create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		IBankAccountMgmtService  service=ctx.getBean("bankService",IBankAccountMgmtService.class);
		try {
			BankAccountDTO dto=new BankAccountDTO();
			dto.setAcno(6784987L); dto.setHolderName("rajesh"); dto.setBalance(90000.0f);
			dto.setStatus("active");
			System.out.println(service.openAccount(dto));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
