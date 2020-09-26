package com.nt.dto;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nt.bo.BaseBean;

@Component("empDTO")
@Scope("prototype")
public class EmployeeDTO extends BaseBean implements Serializable {
	private String  company;
	private float salary;
	
	public EmployeeDTO() {
		System.out.println("EmployeeDTO:: 0-param constructor");
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [company=" + company + ", salary=" + salary + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
