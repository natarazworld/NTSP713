package com.nt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	//@RequestMapping(value="/")
	@RequestMapping
	public   String   showHome() {
		return "home";
	}
	
	
	@RequestMapping(value="/register")
	public   String   saveData1() {
		System.out.println("TestController.saveData1(-)");
		return "redirect:showEmps";
	}
	
	/*@RequestMapping(value="/register",method = RequestMethod.POST)  //POST  
	public   String   saveData2() {
		return 	"result2";
	}*/
}//class
