package com.nt.vo;

import java.io.Serializable;

//@Data
public class EmployeeVO  {
	private String serialNo;
	private String empNo;
	private String ename;
	private String job;
	private  String sal;
	private  String deptNo;
	//getters & setters
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	@Override
	public String toString() {
		return "EmployeeVO [serialNo=" + serialNo + ", empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal="
				+ sal + ", deptNo=" + deptNo + "]";
	}
	
	
	
	

}
