package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/student")
	public   String showForm(@ModelAttribute Student st) {   //for form launching (Initial phase request)
		//keep initial data in Model class obj
		st.setSadd("hyd");
		//return  lvn
		return "student_form";
	}
	
	@PostMapping("/student")
		public   String register(Map<String,Object> map,
				                              @ModelAttribute  Student st) {  //for form submission (post back request)
			System.out.println(st);
			//make form data as the model attribute(result)
			map.put("formData", st);
			
			return "result";
		}
	
	/*@PostMapping("/student")
	public   String register(Map<String,Object> map,
			                              @ModelAttribute Student st) {
		System.out.println(st);
		//make form data as the model attribute(result)
		map.put("formData", st);
		
		return "result";
	}*/

}
