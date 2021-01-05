package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private  Integer eno;
	private  String ename;
	private  String eadd;
	private  Float esalary;
}
