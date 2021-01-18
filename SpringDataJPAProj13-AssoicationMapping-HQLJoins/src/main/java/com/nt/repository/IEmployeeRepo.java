package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query("select e.eno,e.ename,e.eaddrs,e.esalary,d.deptNo,d.deptName,d.deptLocation from Employee e  right join e.dept d")
   public List<Object[]>  getJoinsDataChildToParent();
	
}
