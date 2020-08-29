package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedContainerTest {

	public static void main(String[] args) {
		ApplicationContext parentCtx=null,childCtx=null;
		MainController controller=null;
		List<EmployeeVO> listVO=null;
		//create parent IOC container
		parentCtx=new ClassPathXmlApplicationContext("com/nt/cfgs/business-beans.xml");
		//create child IOC container
		childCtx=new ClassPathXmlApplicationContext(new String[] {"com/nt/cfgs/presentation-beans.xml"},parentCtx);
		//get Controller class object
		controller=childCtx.getBean("controller",MainController.class);
		//invoke method
		System.out.println("...................................................");
		try {
			listVO=controller.gatherEmpsByDesgs("clerk","manager", "salesman");
			//display results
			for(EmployeeVO vo: listVO) {
				System.out.println(vo);
			}
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
		//close containers
		((AbstractApplicationContext) parentCtx).close();
		((AbstractApplicationContext) childCtx).close();

	}//main
}//class
