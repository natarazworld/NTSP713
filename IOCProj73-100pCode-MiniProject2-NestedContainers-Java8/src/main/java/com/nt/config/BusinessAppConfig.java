package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.nt.service","com.nt.dao"})
public class BusinessAppConfig {

	
	@Bean(name="hkDs")
	public  DataSource createDS() {
		HikariDataSource  hkDs=null;
		hkDs=new HikariDataSource();
		hkDs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hkDs.setUsername("system");
		hkDs.setPassword("manager");
		hkDs.setMinimumIdle(10);
		hkDs.setMaximumPoolSize(100);
		return hkDs;
	}
	
}
