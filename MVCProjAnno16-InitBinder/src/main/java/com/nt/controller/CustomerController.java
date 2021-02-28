//CustomerController.java
package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;
import com.nt.validator.CustomerValidator;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerMgmtService service;
	@Autowired
	private  CustomerValidator  validator;
	
	@GetMapping("/customer")
	public  String showForm(@ModelAttribute("cust") Customer cust) {  //initial phase request (form launching)
		 cust.setCadd("hyd");
		 //return lvn
		 return "customer_form";
	}
	
	@PostMapping("/customer")
	public String  registerCustomer(@ModelAttribute("cust") Customer cust,
			                                             BindingResult errors,
			                                             RedirectAttributes redirectAttrs) { // Post back request (form submission)
		
	  //pefrom server side form validations only when client side form valdations are not done
		if(cust.getVflag().equalsIgnoreCase("no")){
     		//perform form validations..
	     	if(validator.supports(cust.getClass()))
		     	      validator.validate(cust, errors);
		
		     if(errors.hasErrors())  //if form validation errors are there
			       return "customer_form"; // lvn
		}//if
		
		
		//Application Logic errors
		if(cust.getBillAmt()>100000) {
			errors.rejectValue("billAmt","billAmt.big");
			return "customer_form";
		}
		
		
		  
		  //use  service
		String resultMsg=service.register(cust);
		//keep result in RedirectAttributes object
		  redirectAttrs.addFlashAttribute("resultMsg", resultMsg);  // make this model data avaliable to next redirected request..
		  redirectAttrs.addFlashAttribute("modelData", cust);
		  //return LVN
		return "redirect:show";
	}
	
	@GetMapping("/show")
	public  String  showResultPage() {
		//return lvn
		return  "result";
	}
	
	//  reference data method using @ModelAttribute
	@ModelAttribute("gendersList")
	public   List<String>  populateGenders(){
		System.out.println("CustomerController.populateGenders()");
		return List.of("male","female");
	}
	
	
//  reference data method using @ModelAttribute
	@ModelAttribute("hobiesList")
	public   List<String>  populateHobies(){
		System.out.println("CustomerController.populateHobies()");
		return List.of("Reading Books","Watching TV","Sleeeping","Playing Games");
	}
	
	
//  reference data method using @ModelAttribute
	@ModelAttribute("countriesList")
	public   Set<String>  populateCountries(){
		System.out.println("CustomerController.populateCountries()");
		//use serivce
		Set<String>  countriesSet=service.fetchAllCountries();
		return countriesSet;
	}
	
//  reference data method using @ModelAttribute
	@ModelAttribute("languagesList")
	public   Set<String>  populateLanguages(){
		System.out.println("CustomerController.populateLanguages()");
		//use serivce
		Set<String>  languagesList=service.fetchAllLaguages();
		return languagesList;
	}
	
	// initBinder to  register Custom PropertyEditors
	@InitBinder
	public   void   myInitBinder(ServletRequestDataBinder binder) {
		System.out.println("CustomerController.myInitBinder()");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// makes the binder obj to use CustomDateEditor to convert given String value(yyyy-MM-dd) to java.util.Date class obj
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true)); 
	}
	
	

}
