package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource(value =  "com/nt/commons/jdbc.properties" )
public class PersistenceConfig {
	@Autowired
   private  Environment env;
	
	@Bean(name="hkDs")
	public   DataSource   createHKDs() {
		HikariDataSource hkDs=new HikariDataSource();
		hkDs.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		hkDs.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		hkDs.setUsername(env.getRequiredProperty("jdbc.username"));
		hkDs.setPassword(env.getRequiredProperty("jdbc.password"));
		hkDs.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("jdbc.minIdle")));
		hkDs.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("jdbc.maxPoolsize")));
		return  hkDs;
	}
	
	@Bean(name="template")
	public  JdbcTemplate  createJT() {
		return  new JdbcTemplate(createHKDs());
	}
	
}//class
