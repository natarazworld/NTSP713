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
		//invoke methods
		/*service.fetchJoinsDataParentToChild().forEach(row->{
			for(Object value:row) {
				System.out.print(value+"   ");
			}
			System.out.println();
		});*/
		System.out.println("--------------------------------------------------");
		service.fetchJoinsDataChildToParent().forEach(row->{
			for(Object val:row) {
				System.out.print(val+"   ");
			}
			System.out.println();
		});
		
		 //close comtainer
		 ((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
