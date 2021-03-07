package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursesController {
	
	@GetMapping("/welcome")
	public   String showHome(){
		return "homePageDef";
	}
	
	@GetMapping("/java")
	public   String showJavaCourses(){
		return "javaPageDef";
	}
	
	@GetMapping("/dotnet")
	public   String showDotNetCourses(){
		return "dotNetPageDef";
	}
	@GetMapping("/oracle")
	public   String showOracleCourses(){
		return "oraclePageDef";
	}
	


}
