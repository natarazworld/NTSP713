package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

@SpringBootApplication
public class SpringDataJpaProj1BootCrudRepoApplication {

	public static void main(String[] args) {
		
		//get  IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj1BootCrudRepoApplication.class, args);
		//get Service class obj
		IEmployeeMgmtService service=ctx.getBean("empService",IEmployeeMgmtService.class);
		//invoke method
		    EmployeeDTO dto=new EmployeeDTO("raja","hyd",67890.0f);
		    System.out.println("Employee registered with Id::"+service.registerEmployee(dto));
		    
		    //close container
		    ((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
