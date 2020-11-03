package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.model.Person;

@SpringBootApplication
public class DaoProj11BootYmlValueConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		//get Container
		ApplicationContext ctx=SpringApplication.run(DaoProj11BootYmlValueConfigurationPropertiesAnnotationApplication.class, args);
	   //get PErson class obj from IOC container
		Person per=ctx.getBean("per",Person.class);
		System.out.println(per);
		
		
	}

}
