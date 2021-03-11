package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageController {
	@Autowired
	private  IWishMessageService  service;
	
	@RequestMapping("/welcome")
	public  String showHome() {
		//return lvn
		return "home";
	}
	
	@RequestMapping("/wish")
	public  String  generateWishMessage(Map<String,Object> map) {
		//us service
		String msg=service.generateWishMessage();
		//keep result in model attribute
		map.put("wMsg",msg);
		//return lvn
		return "result";
		
	}

}
