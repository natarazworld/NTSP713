package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Employee;

public interface IEmployeeRepo extends CrudRepository<Employee,Integer>{

}
