package com.nt.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageController {
	@Autowired
    private  IWishMessageService  service;
	
	@RequestMapping("/welcome")
	public   String showHome() {
		  return  "home";  //lvn
	}
	
	
	
	/*@RequestMapping("/wish")
	public   String   getMessage(Map<String,Object> map) {
		//use serivce
		String msg=service.generateWishMessage();
	   System.out.println(map.getClass());
		
		map.put("sysDate", new Date());
		map.put("wMsg",msg);
		return "result";
	}*/
	
	@RequestMapping("/wish")
	public  void   getMessage(ModelAndView mav) {
		//use serivce
		String msg=service.generateWishMessage();
	     //Model data
		mav.addObject("sysDate", new Date());
		mav.addObject("wMsg",msg);
		//set LVN
		mav.setViewName("result");
	}
	
}//class
