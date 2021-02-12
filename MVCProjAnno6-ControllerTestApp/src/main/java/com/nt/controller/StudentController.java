package com.nt.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@Autowired
	private  ServletContext sc;
	@Autowired
	private  ServletConfig cg;
	
	
	@RequestMapping("/save")
	public  String saveEmp() {
		 System.out.println("Saving employee...");
		return "redirect:showEmps";
	}
	
	@RequestMapping("/delete")
	public  String deleteEmp() {
		 System.out.println("deleting employee...");
		return "redirect:showEmps";
	}
	
	@RequestMapping("/showEmps")
	public  String listEmps(HttpSession ses, HttpServletRequest req) {
		 System.out.println("displaying employees...");
		 System.out.println("web app name ::"+sc.getContextPath());
		 System.out.println("web app path ::"+sc.getRealPath("/"));
		 System.out.println("DS logical name::"+cg.getServletName());
		 System.out.println("Session Id "+ses.getId());
		 System.out.println("req uri "+req.getRequestURI());
		return "show";
	}
	
	
}//class
