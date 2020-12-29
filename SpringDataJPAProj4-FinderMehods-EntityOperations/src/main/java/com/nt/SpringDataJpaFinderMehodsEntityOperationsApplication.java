package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repository.IEmployeeRepo;

@SpringBootApplication
public class SpringDataJpaFinderMehodsEntityOperationsApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaFinderMehodsEntityOperationsApplication.class, args);
		//get Proxy class object
		IEmployeeRepo  repo=ctx.getBean(IEmployeeRepo.class);
		System.out.println("proxy class name::"+repo.getClass());
		//invoke method
		// repo.findByEadd("hyd").forEach(System.out::println);
		 //repo.findByEname("raja").forEach(System.out::println);
		  //repo.findByEnameIs("raja").forEach(System.out::println);
		//repo.findByEnameEquals("raja").forEach(System.out::println);
		 //repo.findByEsalaryLessThan(10000).forEach(System.out::println);
		 //repo.findByEsalaryGreaterThanEqual(10000).forEach(System.out::println);
		//repo.findByEnameLike("r%").forEach(System.out::println);
		//repo.findByEnameStartingWith("r").forEach(System.out::println);
		//repo.findByEnameContaining("a").forEach(System.out::println);
		//repo.findByEaddIn(List.of("hyd","mumbai","delhi")).forEach(System.out::println);
		 //repo.findByEaddNotIn(List.of("hyd","mumbai")).forEach(System.out::println);
		 //repo.findByEaddIsNull().forEach(System.out::println);
		//repo.findByEaddIsNotNull().forEach(System.out::println);
		//repo.findByEaddNotNull().forEach(System.out::println);
		 //repo.findByEaddIgnoreCase("hyd").forEach(System.out::println);
		//repo.findByEaddOrderByEno("hyd").forEach(System.out::println);
		//repo.findByEnameAndEadd("raja", "hyd").forEach(System.out::println);
		//repo.findByEsalaryOrEadd(10000, "hyd").forEach(System.out::println);
		 //repo.findByEsalaryBetween(10000, 100000).forEach(System.out::println);
		
		//repo.findByEnameStartingWithAndEaddStartingWith("r","h").forEach(System.out::println);
		//repo.findByEnameStartingWithAndEaddStartingWith("r","h").forEach(System.out::println);
		//repo.findByEnoGreaterThanEqualAndEnameEndingWithOrEsalaryBetween(100, "a", 10000, 20000).forEach(System.out::println);
		repo.findByEnameInOrEaddIn(List.of("raja","rani","suresh"),List.of("hyd","vizag","delhi")).forEach(System.out::println);
		
	}

}
