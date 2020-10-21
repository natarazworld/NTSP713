package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.service.EmployeeMgmtService;

public class JdbcTemplateDirectMethodsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);  
		//get SErvice class object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke the b.method
		try {
			System.out.println("emps count::"+service.fetchEmpsCount());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("------------------------------------");
		try {
			System.out.println("7499 emp name ::"+service.fetchEmpNameByNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("------------------------------------");
		try {
			System.out.println("7499 emp details"+service.fetchEmpDetailsByNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("------------------------------------");
		try {
			//System.out.println("CLERK ,MANAGER Desg emp details"+service.fetchEmpDetailsByDesgs("CLERK","MANAGER"));
			/*  service.fetchEmpDetailsByDesgs("CLERK","MANAGER").forEach(map->{
				  System.out.println(map);
			  });*/  //java 8 forEach ,  lamda expression
			//  service.fetchEmpDetailsByDesgs("CLERK","MANAGER").forEach(map->  System.out.println(map)  );   //java 8 forEach ,  lamda expression
			  service.fetchEmpDetailsByDesgs("CLERK","MANAGER").forEach(System.out::println );  //java8 foreach , method reference
				
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		/*		System.out.println("------------------------------------");
				
				try {
				   System.out.println(service.registerEmp("amitabl","actor", 50000));		
				}
				catch(DataAccessException dae) {
					dae.printStackTrace();
				}
		*/		
		System.out.println("------------------------------------");
		
		try {
			   System.out.println(service.putBonusToEmpByDesg("SALESMAN",1000));
			}
			catch(DataAccessException dae) {
				dae.printStackTrace();
			}
		
		
		
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
