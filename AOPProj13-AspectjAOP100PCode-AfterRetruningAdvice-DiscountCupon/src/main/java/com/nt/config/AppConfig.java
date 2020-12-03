package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.nt.service","com.nt.aspect"})
@EnableAspectJAutoProxy
public class AppConfig {
		

}
