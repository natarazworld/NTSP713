package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource(value = {"com/nt/commons/jdbc.properties",
		                                       "com/nt/commons/jdbc1.properties"})
public class PersistenceConfig {
	@Autowired
	private Environment env;

	@Bean(name="hkDs")
	public  DataSource createDS() {
		HikariDataSource  hkDs=null;
		hkDs=new HikariDataSource();
		hkDs.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		hkDs.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		hkDs.setUsername(env.getRequiredProperty("jdbc.user"));
		hkDs.setPassword(env.getRequiredProperty("jdbc.pwd"));
		hkDs.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("pool.minsize")));
		hkDs.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("pool.maxsize")));
		System.out.println("system property ::"+env.getProperty("os.name"));
		return hkDs;
	}
}
