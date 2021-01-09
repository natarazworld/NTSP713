package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="DEPARTMENT_OTM")
@Setter
@Getter
public class Department  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptNo;
	@Column(length = 20)
	private  String deptName;
	@Column(length = 20)
	 private  String deptLocation;
	
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL, fetch =FetchType.LAZY ,mappedBy = "dept")
	//@JoinColumn(name = "dept_no",referencedColumnName = "deptNo")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private  Set<Employee>  emps;
	
	public Department() {
		System.out.println("Department:: 0-param constructor");
	}

	  //alt +shift+s ,s
	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", deptLocation=" + deptLocation + "]";
	}
	
	

}
