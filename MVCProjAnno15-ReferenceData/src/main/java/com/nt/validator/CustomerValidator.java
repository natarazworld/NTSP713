//CustomerValidator.java
package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Customer;

@Component("custValidator")
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("CustomerValidator.supports()");
			return clazz.isAssignableFrom(Customer.class);  //To check wheather correct Model class is coming not
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("CustomerValidator.validate()");
		//type casting
		Customer cust=(Customer)target;
		//form validation logics (server side)
		if(cust.getCname()==null || cust.getCname().isBlank())  //required rule
			errors.rejectValue("cname","cname.required");
		else if(cust.getCname().length()<5)  //minlenth rule
			errors.rejectValue("cname","cname.minlen");
		
		if(cust.getCadd()==null || cust.getCadd().isBlank())  //required rule
			errors.rejectValue("cadd","cadd.required");
		else if(cust.getCadd().length()<8)  //minlenth rule
			errors.rejectValue("cadd","cadd.minlen");
		
		if(cust.getBillAmt()==null)  //required rule
			errors.rejectValue("billAmt","billAmt.required");
		else  if(cust.getBillAmt()<=0)  //minlenth rule
			errors.rejectValue("billAmt","billAmt.positive");
	}

}
