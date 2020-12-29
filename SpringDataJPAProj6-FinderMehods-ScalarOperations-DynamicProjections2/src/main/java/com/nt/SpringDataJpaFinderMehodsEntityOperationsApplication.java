package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repository.IEmployeeRepo;
import com.nt.view.ResultView1;
import com.nt.view.ResultView2;
import com.nt.view.ResultView3;
import com.nt.view.ResultView4;

@SpringBootApplication
public class SpringDataJpaFinderMehodsEntityOperationsApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaFinderMehodsEntityOperationsApplication.class, args);
		//get Proxy class object
		IEmployeeRepo  repo=ctx.getBean(IEmployeeRepo.class);
		//invoke methods
		List<ResultView1> list1=repo.findByEadd("hyd", ResultView1.class);
		list1.forEach(view1->{
			System.out.println(view1.getEno()+"  "+view1.getEadd());
		});
		System.out.println("---------------------------------");
		List<ResultView2> list2=repo.findByEadd("hyd", ResultView2.class);
		list2.forEach(view2->{
			System.out.println(view2.getEname()+"  "+view2.getEadd());
		});
		System.out.println("---------------------------------");
		List<ResultView3> list3=repo.findByEadd("hyd", ResultView3.class);
		list3.forEach(view3->{
			System.out.println(view3.getEno()+"  "+view3.getEname()+"  "+view3.getEadd());
		});
		System.out.println(".......................................");
		List<ResultView4> list4=repo.findByEadd("hyd", ResultView4.class);
		list4.forEach(view4->{
			 System.out.println(view4.getEname());
		});
	}

}
