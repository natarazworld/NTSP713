package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("per")
@Data
@ConfigurationProperties(prefix="per.info")
public class Person {
	//@Value("${info.per.id}")
	private int id;
	//@Value("${info.per.name}")
	private String name;
	//@Value("${info.per.addrs}")
	private String addrs; 
	private int marks1[];
	private List<Integer> marks2;
	private Set<Integer> marks3;
	private Map<String,Long> phones;
	private  Job job;
	

}
