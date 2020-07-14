package com.nt.beans;

public class Employee {
	private int eno;
	private  float salary;
	private String ename;
	
	
	// alt+shift+s , o
	public Employee(int eno, String ename, float salary) {
		System.out.println("Employee:: 3-param construtor");
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
	}

	  //alt+shift+s, s
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", salary=" + salary + "]";
	}
	
}
