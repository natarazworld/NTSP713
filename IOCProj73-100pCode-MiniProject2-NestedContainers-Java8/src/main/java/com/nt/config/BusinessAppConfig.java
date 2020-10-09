package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Import(value= {PersistenceConfig.class,ServiceConfig.class})
public class BusinessAppConfig {
	
	
	
}
