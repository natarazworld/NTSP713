package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.User;
import com.nt.service.ILoginService;

@Controller
public class LoginController {
	@Autowired
	private  ILoginService service;

	@GetMapping("/")
	public  String lauchWelcomefile() {
		return "redirect:login";
	}
	
	@GetMapping("/login")
	public  String showForm(@ModelAttribute("userForm") User user) {
		//return lvn
		return "login_form";
	}
	
	@PostMapping("/login")
	public String  processForm(Map<String,Object> map,
			                                     @ModelAttribute("userForm") User user) {
		//use service
		String result=service.validate(user);
		//keep the result in model attributes
		map.put("resultMsg",result);
		//return lvn
		return "login_form";
	}
	
}
