package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Department;

public interface IDepartmentRepo extends JpaRepository<Department, Integer> {

	//@Query("select d.deptNo,d.deptName,d.deptLocation,e.eno,e.ename,e.eaddrs,e.esalary from Department d  inner join d.emps e")
	//@Query("select d.deptNo,d.deptName,d.deptLocation,e.eno,e.ename,e.eaddrs,e.esalary from Department d  left join d.emps e")
	//@Query("select d.deptNo,d.deptName,d.deptLocation,e.eno,e.ename,e.eaddrs,e.esalary from Department d  right join d.emps e")
	@Query("select d.deptNo,d.deptName,d.deptLocation,e.eno,e.ename,e.eaddrs,e.esalary from Department d  full join d.emps e")

	public    List<Object[]>    getJoinsDataParentToChild();
}
