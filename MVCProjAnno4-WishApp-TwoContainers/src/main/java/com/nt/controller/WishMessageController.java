package com.nt.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageController {
	@Autowired
    private  IWishMessageService  service;
	
	@RequestMapping("/welcome.htm")
	public   String showHome() {
		  return  "home";  //lvn
	}
	
	/*@RequestMapping("/wish.htm")
	public   ModelAndView   getMessage() {
		//use serivce
		String msg=service.generateWishMessage();
		//return MAV object
		ModelAndView mav=new ModelAndView();
		mav.addObject("wMsg", msg);  //model attr1
		mav.addObject("sysDate", new Date());  //model attr2
		mav.setViewName("result");  //lvn
		return mav;
	}*/
	
	/*	@RequestMapping("/wish.htm")
		public   String   getMessage(Model model) {
			//use serivce
			String msg=service.generateWishMessage();
			System.out.println(model.getClass());
			//return MAV object
			model.addAttribute("sysDate", new Date());
			model.addAttribute("wMsg",msg);
			return "result";
		}
	*/	
/*   @RequestMapping("/wish.htm")
	public   String   getMessage(ModelMap map) {
		//use serivce
		String msg=service.generateWishMessage();
	System.out.println(map.getClass());
		
		map.addAttribute("sysDate", new Date());
		map.addAttribute("wMsg",msg);
		return "result";
	}*/
	
/*@RequestMapping("/wish.htm")
public   String   getMessage(Map<String,Object> map) {
	//use serivce
	String msg=service.generateWishMessage();
System.out.println(map.getClass());
	
	map.put("sysDate", new Date());
	map.put("wMsg",msg);
	return "result";
}*/
	
/*@RequestMapping("/wish.htm")
public   void   getMessage(Map<String,Object> map) {
	//use serivce
	String msg=service.generateWishMessage();
   System.out.println(map.getClass());
	map.put("sysDate", new Date());
	map.put("wMsg",msg);
}*/
	
	
/*@RequestMapping("/wish.htm")
public   Model   getMessage() {
	//use serivce
	String msg=service.generateWishMessage();
	//retrun  Model object
	Model model=new BindingAwareModelMap();
	model.addAttribute("sysDate", new Date());
	model.addAttribute("wMsg",msg);
	return model;
}
*/	
	
	@RequestMapping("/wish.htm")
	public   Map<String,Object>   getMessage() {
		//use serivce
		String msg=service.generateWishMessage();
		//retrun  Map object
		Map map=new HashMap();
		map.put("sysDate", new Date());
		map.put("wMsg",msg);
		return map;
	}

	
	   
	
}//class
