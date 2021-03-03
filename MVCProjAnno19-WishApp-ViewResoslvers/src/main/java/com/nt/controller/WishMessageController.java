package com.nt.controller;

import java.util.Date;
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
	public   String showHome() {
		  return  "home";  //lvn
	}
	
	@RequestMapping("/about")
	public String showAboutUsPage() {
		//return lvn
		return "about_us";
	}
	
	
	@RequestMapping("/wish")
	public   String   getMessage(Map<String,Object> map) {
		//use serivce
		String msg=service.generateWishMessage();
	   System.out.println(map.getClass());
		
		map.put("sysDate", new Date());
		map.put("wMsg",msg);
		return "result";
	}
	
	
	
}//class
