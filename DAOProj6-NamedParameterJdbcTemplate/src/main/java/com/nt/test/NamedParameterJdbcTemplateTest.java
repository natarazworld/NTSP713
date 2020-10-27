package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		IEmployeeMgmtService service=ctx.getBean("empService",IEmployeeMgmtService.class);
		//invoke method
		try {
			System.out.println("empName::"+service.fetchEmpNameByNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("=====================================");
		try {
			System.out.println("emp details by desgs CLERK,MANAGER,ANALYST");
			service.fetchEmpDetailsByDesgs("CLERK","MANAGER","ANALYST").forEach(System.out::println);
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("===================================");
		try {
			EmployeeDTO dto=new EmployeeDTO();
			dto.setEmpNo(9091);dto.setEname("rajesh"); dto.setJob("CLERK"); dto.setSal(9000.0f);
			System.out.println(service.registerEmployee(dto));
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
