package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerMgmtService service;
	
	@GetMapping("/customer")
	public  String showForm(@ModelAttribute("cust") Customer cust) {
		 cust.setCadd("hyd");
		 //return lvn
		 return "customer_form";
	}
	
	@PostMapping("/customer")
	public String  registerCustomer(Map<String,Object>map,
			                                            @ModelAttribute("cust") Customer cust) {
		  //use  service
		String resultMsg=service.register(cust);
		//keep result in model attribute
		map.put("resultMsg", resultMsg);
		//return LVN
		return "result";
	}

}
