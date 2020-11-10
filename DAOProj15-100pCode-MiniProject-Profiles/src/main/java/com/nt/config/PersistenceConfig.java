package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean
	@Profile("dev")
	public   DataSource  createC3PODS() throws Exception {
		System.out.println("PersistenceConfig.createC3PODS()");
		ComboPooledDataSource ds=new  ComboPooledDataSource();
		ds.setDriverClass("com.mysql.cj.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql:///ntsp713db");
		ds.setUser("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean
	@Profile("test")
	public   DataSource  createApacheDBCPDSMysql() throws Exception {
		System.out.println("PersistenceConfig.createApacheDBCPDSMysql()");
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql:///ntsp713db");
		bds.setUsername("root");
		bds.setPassword("root");
		return bds;
	}
	
	@Bean
	@Profile("uat")
	public   DataSource  createApacheDBCPDSOracle() throws Exception {
		System.out.println("PersistenceConfig.createApacheDBCPDSOracle()");
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("system");
		bds.setPassword("manager");
		return bds;
	}
	
	@Bean
	@Profile("prod")
	public   DataSource  createHKCPDS() throws Exception {
		System.out.println("PersistenceConfig.createHKCPDS()");
		HikariDataSource hds=new HikariDataSource();
		hds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hds.setUsername("system");
		hds.setPassword("manager");
		return hds;
	}
	
	@Bean
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
	}
	
	
	
}
