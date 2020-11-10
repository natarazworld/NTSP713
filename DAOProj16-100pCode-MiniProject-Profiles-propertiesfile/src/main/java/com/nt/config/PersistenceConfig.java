package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource("com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	@Autowired
	private   Environment env;
	
	@Bean
	@Profile("dev")
	public   DataSource  createC3PODS() throws Exception {
		System.out.println("PersistenceConfig.createC3PODS()");
		ComboPooledDataSource ds=new  ComboPooledDataSource();
		ds.setDriverClass(env.getRequiredProperty("jdbc.mysql.driverclass"));
		ds.setJdbcUrl(env.getRequiredProperty("jdbc.mysql.url"));
		ds.setUser(env.getRequiredProperty("jdbc.mysql.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.mysql.pwd"));
		return ds;
	}
	
	@Bean
	@Profile("test")
	public   DataSource  createApacheDBCPDSMysql() throws Exception {
		System.out.println("PersistenceConfig.createApacheDBCPDSMysql()");
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getRequiredProperty("jdbc.mysql.driverclass"));
		ds.setUrl(env.getRequiredProperty("jdbc.mysql.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.mysql.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.mysql.pwd"));
		return ds;
	}
	
	@Bean
	@Profile("uat")
	public   DataSource  createApacheDBCPDSOracle() throws Exception {
		System.out.println("PersistenceConfig.createApacheDBCPDSOracle()");
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getRequiredProperty("jdbc.oracle.driverclass"));
		ds.setUrl(env.getRequiredProperty("jdbc.oracle.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.oracle.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.oracle.pwd"));
		return ds;
	}
	
	@Bean
	@Profile("prod")
	public   DataSource  createHKCPDS() throws Exception {
		System.out.println("PersistenceConfig.createHKCPDS()");
		HikariDataSource ds=new HikariDataSource();
		ds.setDriverClassName(env.getRequiredProperty("jdbc.oracle.driverclass"));
		ds.setJdbcUrl(env.getRequiredProperty("jdbc.oracle.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.oracle.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.oracle.pwd"));
		return ds;
	}
	
	
	@Bean(autowire = Autowire.BY_TYPE)
	@Autowired
	public  JdbcTemplate createJT() throws Exception {
		return new JdbcTemplate();
	}
	
	/*@Bean
	@Profile("dev")
	public  JdbcTemplate createJTUsingC3PODs() throws Exception {
		System.out.println("PersistenceConfig.createJTUsingC3PODs()");
		return new JdbcTemplate(createC3PODS());
	}
	
	@Bean
	@Profile("uat")
	public  JdbcTemplate createJTUsingApacheDBCPDsWithOracle() throws Exception {
	 System.out.println("PersistenceConfig.createJTUsingApacheDBCPDsWithOracle()");
		return new JdbcTemplate(createApacheDBCPDSOracle());
	}
	
	@Bean
	@Profile("test")
	public  JdbcTemplate createJTUsingApacheDBCPDsWithMysql() throws Exception {
	 System.out.println("PersistenceConfig.createJTUsingApacheDBCPDsWithMysql()");
		return new JdbcTemplate(createApacheDBCPDSMysql());
	}
	
	
	@Bean
	@Profile("prod")
	public  JdbcTemplate createJTUsingHKCPDs() throws Exception {
	 System.out.println("PersistenceConfig.createJTUsingHKCPDs()");
		return new JdbcTemplate(createHKCPDS());
	}*/
	
	
	
}
