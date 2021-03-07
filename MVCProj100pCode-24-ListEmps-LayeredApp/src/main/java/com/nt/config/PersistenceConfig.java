package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource(value="classpath:com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	@Autowired
	private Environment env;
	
	@Bean(name="jofb")
	public  JndiObjectFactoryBean  createJOFB() {
		JndiObjectFactoryBean  jofb=new JndiObjectFactoryBean();
		jofb.setJndiName(env.getRequiredProperty("ds.jndi"));
		return jofb;
	}
	
	@Bean(name="jt")
	public  JdbcTemplate createJT() {
		JdbcTemplate  jt=new JdbcTemplate();
		jt.setDataSource((DataSource)createJOFB().getObject());  //getObject() callsed FactoryBean obj gives Resultant obj(DataSource obj)
		return jt;
	}
}
