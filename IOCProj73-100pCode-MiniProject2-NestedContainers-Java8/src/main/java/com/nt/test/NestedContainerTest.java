package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.BusinessAppConfig;
import com.nt.config.PresentationAppConfig;
import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedContainerTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext parentCtx=null,childCtx=null;
		MainController controller=null;
		List<EmployeeVO> listVO=null;
		//create parent IOC container
		parentCtx=new AnnotationConfigApplicationContext(BusinessAppConfig.class);
		//create child IOC container
		
		/*	childCtx=new AnnotationConfigApplicationContext(PresentationAppConfig.class);
			childCtx.setParent(parentCtx);*/
		
		childCtx=new AnnotationConfigApplicationContext();
		childCtx.setParent(parentCtx);
		childCtx.register(PresentationAppConfig.class);
		childCtx.refresh();  //To perform pre-instantation of singletonscope beans..
		
		//get Controller class object
		controller=childCtx.getBean("controller",MainController.class);
		//invoke method
		System.out.println("...................................................");
		try {
			listVO=controller.gatherEmpsByDesgs("clerk","manager", "salesman");
			//display results
			/*for(EmployeeVO vo: listVO) {
				System.out.println(vo);
			}*/
		/*	listVO.forEach(vo->{    //java 8 for each + lambda
				System.out.println(vo);
			});*/
			
			//listVO.forEach(vo-> 	System.out.println(vo)	);
			
			listVO.forEach(System.out::println);  // java 8 forEach + method reference   -->  :: method referece opeartor
			
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
		//close containers
		((AbstractApplicationContext) parentCtx).close();
		((AbstractApplicationContext) childCtx).close();

	}//main
}//class
