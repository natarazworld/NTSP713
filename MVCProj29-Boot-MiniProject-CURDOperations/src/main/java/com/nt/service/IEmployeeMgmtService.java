package com.nt.service;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {

	public  Iterable<Employee>  fetchAllEmployees();
	public  Employee   fetchEmployeeByEno(int eno);
	public  String    updateEmployee(Employee emp);
	public  void   deleteEmployee(int eno);
	
}
