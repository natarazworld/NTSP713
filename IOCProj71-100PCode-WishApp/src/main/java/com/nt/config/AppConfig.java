package com.nt.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.nt.beans")   //alternate <context:componet-scan> tag
public class AppConfig {
	
	static {
		System.out.println("AppConfig.static block");
	}
	
	public AppConfig() {
		System.out.println("AppConfig: 0-param constructor");
	}
	
	//@Bean(name="dt")
	@Bean
	public   LocalDateTime  createSysDateTime() {
		System.out.println("AppConfig.createSysDateTime()");
		return LocalDateTime.now();  //static factory method returning its own class object 
	}

}
