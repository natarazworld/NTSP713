package com.nt;

import java.util.List;

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
		/*    EmployeeDTO dto=new EmployeeDTO("suresh","vizag",67890.0f);
		    System.out.println("Employee registered with Id::"+service.registerEmployee(dto));*/
		
	/*	    EmployeeDTO dto=new EmployeeDTO(21,"raja","mumbai",6757.0f);
	    System.out.println("Updating record ::"+service.registerEmployee(dto)); */
		
	/*	 int ids[]=service.registerEmployeesGroup(List.of(new EmployeeDTO("rama","hyd",9000.0f),
				                                                                               new  EmployeeDTO("jani","vizag",80000.0f),
				                                                                              new EmployeeDTO("albert","delhi",70000.0f)
				                                                                                    ));
		 System.out.println("batch of saved objs  ids are ::"+Arrays.toString(ids));*/
		
		//System.out.println("Employees count::"+service.getEmployeesCount());
		//System.out.println(service.removeEmployeeById(101));
		/*Optional<EmployeeDTO>  optDTO=service.getEmployeeById(122);
		 if(optDTO.isPresent())
		  System.out.println("22 employee details "+optDTO.get());
		 else
			 System.out.println("employee not found" );*/
		  
		//System.out.println(service.removeEmployeeById1(125));
		
		//service.getAllEmployees().forEach(System.out::println);  
		//service.getAllEmployees().forEach(dto-> System.out.println(dto));
		
		/*try {
		 System.out.println(service.removeEmployeesByGivenEntities(List.of(new EmployeeDTO(26),
				                                                                                                                 new EmployeeDTO(27),
				                                                                                                                  new EmployeeDTO(28))));
		}
		catch(Exception e) {
		 System.out.println("Problem in bulk deletion");
		 e.printStackTrace();
		}*/
		
		service.getEmployeesByIds(List.of(25,26,24)).forEach(System.out::println);
		
		    //close container
		    ((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
