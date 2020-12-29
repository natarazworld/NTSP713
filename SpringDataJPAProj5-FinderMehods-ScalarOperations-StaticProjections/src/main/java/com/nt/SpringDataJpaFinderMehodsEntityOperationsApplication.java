package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repository.IEmployeeRepo;
import com.nt.repository.ResultView;

@SpringBootApplication
public class SpringDataJpaFinderMehodsEntityOperationsApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaFinderMehodsEntityOperationsApplication.class, args);
		//get Proxy class object
		IEmployeeRepo  repo=ctx.getBean(IEmployeeRepo.class);
		//invoke methods
		/*List<ResultView> list=repo.findByEaddIn(List.of("hyd","vizag","mumbai"));
		list.forEach(view->{
			System.out.println(view.getEno()+"   "+view.getEadd());
		});*/
		repo.findByEaddIn(List.of("hyd","vizag","mumbai")).forEach(view->System.out.println(view.getEno()+"  "+view.getEadd()));
		
		
	}

}
