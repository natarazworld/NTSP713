package com.nt.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(name="time")
     public   LocalTime createTime() {
    	 return  LocalTime.now();
     }
	

}
