 //SpringDataMongoDb14CurdOperationsApplication.java
package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Customer;
import com.nt.repository.CustomerRepo;

@SpringBootApplication
public class SpringDataMongoDb14CurdOperationsApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataMongoDb14CurdOperationsApplication.class, args);
		//get Service obj
		CustomerRepo repo=ctx.getBean(CustomerRepo.class);
		//invoke methods
		/*List<Object[]> list=repo.getData("hyd");
		list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+"  ");
			}
			System.out.println();
		});
		*/
		System.out.println("..................................");
		/*List<Customer> list=repo.getAllData("hyd");
		list.forEach(cust->{
			System.out.println(cust);
		});*/
		
		/*System.out.println("..................................");
		List<Customer> list=repo.getAllData1("hyd","suresh");
		list.forEach(cust->{
			System.out.println(cust);
		});*/
		
		System.out.println("..................................");
		//List<Customer> list=repo.getRegData("^h");  // cadd starting with h
		//List<Customer> list=repo.getRegData("g$");  // cadd end with g
		/*		List<Customer> list=repo.getRegData("z");  // cadd containing  y
				list.forEach(cust->{
					System.out.println(cust);
				});
		*/		
		
	/*	List<Customer> list=repo.getDataByCnoRange(3000,10000);
		list.forEach(System.out::println); */
		
		List<Customer> list=repo.getDataByOrCond("^s","hyd");
		list.forEach(System.out::println);
		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
