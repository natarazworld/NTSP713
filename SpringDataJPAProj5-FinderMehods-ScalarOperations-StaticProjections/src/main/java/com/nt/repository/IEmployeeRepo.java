package com.nt.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.entity.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
      
	  //SELECT  ENO,EADD  FROM EMPLOYEE  WHERE EADD IN('hyd','mumbai','delhi') 
	   public  List<ResultView>  findByEaddIn(Collection<String> cities);
      
}
