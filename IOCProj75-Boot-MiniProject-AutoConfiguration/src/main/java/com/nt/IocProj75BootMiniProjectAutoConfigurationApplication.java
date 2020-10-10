package com.nt;

import java.io.Closeable;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;



@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
public class IocProj75BootMiniProjectAutoConfigurationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		MainController controller=null;
		Scanner sc=null;
		CustomerVO vo=null;
		String name=null,cadd=null,pamt,rate,time;
		
		// read inputs
		sc = new Scanner(System.in);
		System.out.println("enter Customername :: ");
		name = sc.next();
		System.out.println("Enter customer Addrs::");
		cadd = sc.next();
		System.out.println("Enter Principle  amount::");
		pamt = sc.next();
		System.out.println("Enter rate of intrest::");
		rate = sc.next();
		System.out.println("Enter time   ::");
		time = sc.next();
		// Store inputs in VO class object
		vo = new CustomerVO();
		vo.setCname(name);
		vo.setCadd(cadd);
		vo.setpAmt(pamt);
		vo.setRate(rate);
		vo.setTime(time);
		//get IOC container
				//ctx=SpringApplication.run(IocProj75BootMiniProjectAutoConfigurationApplication.class, args);
		     // Bootstrapping Spring boot
		    SpringApplication app=new SpringApplication();
		    app.setBannerMode(org.springframework.boot.Banner.Mode.CONSOLE);
		    ctx=app.run(IocProj75BootMiniProjectAutoConfigurationApplication.class, args);
				//get Controller class obj
				controller=ctx.getBean("controller",MainController.class);
		//invoke b.method
		try {
		   System.out.println(controller.processCustomer(vo));
		}
		catch(Exception e) {
			System.out.println("Internal Problem.");
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
