package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishMessageService;

@Controller
public class WishMessageController {
	@Autowired
	private WishMessageService  service;
	
	@RequestMapping("/welcome")
	public   String  showHome() {
		return "home";
	}
	
	@RequestMapping("/wish")
	public  String getWishMessage(Map<String,Object> map) {
		//use service 
		String msg=service.generateWishMessage();
		//keep results in model attribute
		map.put("wishMsg",msg);
		return "result";
	}

}
