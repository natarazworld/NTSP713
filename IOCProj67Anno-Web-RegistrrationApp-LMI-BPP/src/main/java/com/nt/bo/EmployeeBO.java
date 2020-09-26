package com.nt.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("empBO")
@Scope("prototype")
public class EmployeeBO extends BaseBean {
	private String  company;
	private float salary;
	private float grossSalary;
	private float netSalary;
	
	public EmployeeBO() {
		System.out.println("EmployeeBO:: 0-param constructor");
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
	public float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
	
	@Override
	public String toString() {
		return "EmployeeBO [company=" + company + ", salary=" + salary + ", grossSalary=" + grossSalary + ", netSalary="
				+ netSalary + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
