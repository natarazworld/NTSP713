package com.nt.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.entity.Employee;
import com.nt.view.View;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
      
	  public  <T extends View> List<T>  findByEadd(String addrs,Class<T> clazz); 
	   
      
}
