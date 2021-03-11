package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo  empRepo;

	@Override
	public Iterable<Employee> fetchAllEmployees() {
		return empRepo.findAll();
	}
	
	@Override
	public Employee fetchEmployeeByEno(int eno) {
		//use repo
	 Optional<Employee> opt=empRepo.findById(eno);
	    if(opt.isPresent())
	    	return opt.get();   //returns  Employee 
	    else
	       return null;
	}
	
	@Override
	public String updateEmployee(Employee emp) {
		 //use repo
		Employee emp1=empRepo.save(emp);
		if(emp1!=null)
		     return emp1.getEno()+" is updated sucessfully1 ";
		else
			 return emp.getEno()+" is not found to update1 ";
	}
	
	@Override
	public void deleteEmployee(int eno) {
         //use empRepo
		  empRepo.deleteById(eno);
	}

}
