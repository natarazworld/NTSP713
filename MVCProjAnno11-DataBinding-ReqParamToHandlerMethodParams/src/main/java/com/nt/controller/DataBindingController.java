package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataBindingController {
	
	/*@GetMapping("/inputs")
	public  String  readData(Map<String,Object > map,
			                                  @RequestParam("sno") int no, 
			                                  @RequestParam("sname") String name) {
		//make the recieved req params as the Model attributes
		 map.put("stno",no);
		 map.put("stname",name);
		 //return lvn
		 return "result";
		
	}*/
	
	/*	@GetMapping("/inputs")
		public  String  readData(Map<String,Object > map,
				                                  @RequestParam int sno, 
				                                  @RequestParam(required = false,defaultValue = "Anonymous Student") String sname,
				                                   @RequestParam String subjects) {
			System.out.println("sno="+sno+",sname="+sname);
			//make the recieved req params as the Model attributes
			 map.put("stno",sno);
			 map.put("stname",sname);
			 map.put("subjects", subjects);
			 //return lvn
			 return "result";
			
		}*/
	
	@GetMapping("/inputs")
	public  String  readData(Map<String,Object > map,
			                                  //@RequestParam(required = false,defaultValue = "0") int sno,
			                                      @RequestParam(required = false) Integer sno,
			                                  @RequestParam(required = false,defaultValue = "Anonymous Student") String sname,
			                                   @RequestParam String[] subs) {
		System.out.println("sno="+sno+",sname="+sname);
		//make the recieved req params as the Model attributes
		 map.put("stno",sno);
		 map.put("stname",sname);
		 map.put("subs", subs);
		 //return lvn
		 return "result";
		
	}

}
