package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.ICompanyMgmtService;

@SpringBootApplication
public class SpringDataJpa12AssoicationMappingOneToManyApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpa12AssoicationMappingOneToManyApplication.class, args);
		//get Service class object
		ICompanyMgmtService  service=ctx.getBean("compService",ICompanyMgmtService.class);
		/*	//inoke methods
			 try {
				 service.saveDataUsingParent();
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }*/
		
		/*	//inoke methods
			 try {
				 service.saveDataUsingChilds();
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }*/
		
		/*   try {
			   service.loadDataUsingParent();
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }*/
		
		   try {
			service.loadDataUsingChilds();
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }
		
		
		 //close comtainer
		 ((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
