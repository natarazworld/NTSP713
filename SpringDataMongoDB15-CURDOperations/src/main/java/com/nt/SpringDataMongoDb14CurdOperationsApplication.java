 //SpringDataMongoDb14CurdOperationsApplication.java
package com.nt;

import java.util.Optional;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.CustomerDTO;
import com.nt.service.ICustomerMgmtService;

@SpringBootApplication
public class SpringDataMongoDb14CurdOperationsApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataMongoDb14CurdOperationsApplication.class, args);
		//get Service obj
		ICustomerMgmtService service=ctx.getBean("custService",ICustomerMgmtService.class);
				System.out.println("---------------save oepration-----------------");
			/*	System.out.println(service.registerOrUpdateCustomer(new CustomerDTO(new Random().nextInt(60000), "rajesh",18890.0f, "hyd")));
				System.out.println(service.registerOrUpdateCustomer(new CustomerDTO(new Random().nextInt(60000), "suresh",1190.0f, "hyd"))); */
		
		/*System.out.println("---------------update operation-----------------");
		System.out.println(service.registerOrUpdateCustomer(new CustomerDTO(54600, "ramesh",9890.0f, "hyd"))); */
		System.out.println("---------------select operation-----------------");
		//service.fetchAllCustomers().forEach(System.out::println);
		
	/*	Optional<CustomerDTO> opt=service.fetchCustomerByCno(54600);
		if(opt.isPresent())
			  System.out.println(opt.get());
		else
			System.out.println("document not found"); */
		
		  //service.fetchCustomersByCadd("hyd").forEach(System.out::println);
		  service.fetchCustomersByCnoRange(5000, 100000).forEach(System.out::println);
		
		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
