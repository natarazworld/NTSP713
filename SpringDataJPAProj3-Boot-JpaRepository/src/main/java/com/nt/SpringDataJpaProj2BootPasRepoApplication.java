package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

@SpringBootApplication
public class SpringDataJpaProj2BootPasRepoApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj2BootPasRepoApplication.class, args);
		//get Service class obj
		IEmployeeMgmtService service=ctx.getBean("empService",IEmployeeMgmtService.class);
		//invoke methods
		 //System.out.println("emp details"+service.fetchEmployeeById(21));
		
		//service.fetchEmployeesExampleData(new EmployeeDTO(null,"jani","vizag",80000.0f),"ename", true).forEach(System.out::println);
		try {
			service.removeEmployeesInBatch(List.of(new EmployeeDTO(1),new EmployeeDTO(2),new EmployeeDTO(25)));
			System.out.println("Employees deleted in batch");
		}
		catch(Exception e) {
			System.out.println("Problem in the deletion of Employees");
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
