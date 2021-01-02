package com.nt;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IEmployeeMgmtService;

@SpringBootApplication
public class SpringDataJpa8CallingPlSqlProcedureApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpa8CallingPlSqlProcedureApplication.class, args);
		//get Service class obj
		IEmployeeMgmtService  service=ctx.getBean("empService",IEmployeeMgmtService.class);
		//invoke method
		//service.fetchEmpsBySalaryRange(10000, 100000).forEach(System.out::println);
		 System.out.println("------------------------------------");
		 service.fetchEmpsDataByCities("hyd","delhi").forEach(data->System.out.println(Arrays.toString(data)));
		 
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
