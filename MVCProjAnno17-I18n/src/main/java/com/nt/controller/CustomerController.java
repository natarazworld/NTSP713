package com.nt.controller;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.Customer;

@Controller
public class CustomerController {

	@RequestMapping("/customer")
	public  String showForm(Map<String,Object> map,@ModelAttribute("cust") Customer cust) {
		cust.setCadd("hyd");
		//keep model data
		map.put("sysDate", new Date());
		map.put("salary", new Random().nextInt(2000000));
		//return lvn
		return "customer_form";
	}

}
