package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	@Autowired
	 private IEmployeeMgmtService  service;
	
	@GetMapping("/welcome")
	public  String showHome() {
		return "home";
	}
	
	@GetMapping("/report")
	public   String  showEmployees(Map<String,Object> map) {
		//use service
		Iterable<Employee> it=service.fetchAllEmployees();
		//result in model attribute
		map.put("empsList",it);
		//return lnv
		return "show_emps";
	}

}
