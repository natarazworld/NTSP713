package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.model.Person;

@SpringBootApplication
public class DaoProj10BootPropertiesValueConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		//get IOC container
		ctx=SpringApplication.run(DaoProj10BootPropertiesValueConfigurationPropertiesAnnotationApplication.class, args);
	     //get Spring bean class object
		Person per=ctx.getBean("per",Person.class);
		System.out.println(per);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
