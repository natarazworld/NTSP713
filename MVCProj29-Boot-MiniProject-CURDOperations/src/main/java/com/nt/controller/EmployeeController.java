package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/edit")
	public  String  showEmployeeEditForm(@RequestParam("no") int eno,
			                                                             @ModelAttribute("empFrm") Employee emp) {
		//use service
		Employee emp1=service.fetchEmployeeByEno(eno);
		//copy recived data (emp1) to  emp
		BeanUtils.copyProperties(emp1,emp);
	    //return LVN
		return "edit_employee";
	}
	
	/*	@PostMapping("/edit")
		public   String  editEmployee(Map<String,Object> map,@ModelAttribute("empFrm") Employee emp) {
			//use service
			String msg=service.updateEmployee(emp);
			Iterable<Employee> it=service.fetchAllEmployees();
				//result in model attribute
					map.put("empsList",it);
					map.put("resultMsg",msg);
			//return lnv
				return "show_emps";
		}//method
	*/
	
	@PostMapping("/edit")
	public   String  editEmployee(RedirectAttributes attrs,@ModelAttribute("empFrm") Employee emp) {
		//use service
		String msg=service.updateEmployee(emp);
			//result in model attributes as flash attributes
		     attrs.addFlashAttribute("resultMsg",msg);
           return "redirect:report";				
	}//method
	
	
	@GetMapping("/delete")
	public   String    deleteEmployee(RedirectAttributes attrs,
			                                                 @RequestParam("no") int eno) {
		//use service
		service.deleteEmployee(eno);
		//keep result as model Attribute
		 attrs.addFlashAttribute("resultMsg",eno+" Employee deleted");
		  return "redirect:report";				
	}
	
	
}//class
