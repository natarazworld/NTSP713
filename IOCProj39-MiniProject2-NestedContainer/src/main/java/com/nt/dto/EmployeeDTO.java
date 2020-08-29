package com.nt.dto;

import java.io.Serializable;

//@Data
public class EmployeeDTO implements Serializable {
	private Integer serialNo;
	private Integer empNo;
	private String ename;
	private String job;
	private  Float sal;
	private  Integer deptNo;
	
	//getters & setters
	
	
	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
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

	public Float getSal() {
		return sal;
	}

	public void setSal(Float sal) {
		this.sal = sal;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	//toString
	@Override
	public String toString() {
		return "EmployeeDTO [serialNo=" + serialNo + ", empNo=" + empNo + ", ename=" + ename + ", job=" + job + ", sal="
				+ sal + ", deptNo=" + deptNo + "]";
	}

}
