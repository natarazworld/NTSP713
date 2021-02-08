package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.service.IWishMessageService;

public class WishMessageController implements Controller {
	
	private IWishMessageService  service;
	
	public WishMessageController(IWishMessageService service) {
	    this.service=service;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	       //use  service
		String msg=service.generateWishMessage();
		//return MAV
		return new ModelAndView("result", "wMsg", msg);
	}

}
