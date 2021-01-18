package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EMPLOYEE_OTM")
@Setter
@Getter
public class Employee  implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "eno_seq1",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer eno;
	@Column(length = 20)
	private String ename;
	@Column(length = 20)
	private  String eaddrs;
	private  Float esalary;
	
	@ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="dept_no",referencedColumnName = "deptNo")
	private Department dept;
	
	public Employee() {
		System.out.println("Employee:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eaddrs=" + eaddrs + ", esalary=" + esalary + "]";
	}
	
	
	

}
