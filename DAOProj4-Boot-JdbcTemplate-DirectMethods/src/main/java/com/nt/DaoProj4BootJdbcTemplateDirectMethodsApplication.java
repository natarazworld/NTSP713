package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
public class DaoProj4BootJdbcTemplateDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		//get IOC container
		ctx=SpringApplication.run(DaoProj4BootJdbcTemplateDirectMethodsApplication.class, args);
		// get Service class object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke method
		try {
			System.out.println("emps count::"+service.fetchEmpsCount());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
