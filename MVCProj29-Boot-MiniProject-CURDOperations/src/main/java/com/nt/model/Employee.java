package com.nt.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer eno;
	private String ename;
	private String eadd;
	private Float esalary;
	

}
