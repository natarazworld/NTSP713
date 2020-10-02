package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//@Component("wmg")
@Component
public class WishMessageGenerator {
	@Autowired
	private LocalDateTime date;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:: 0-param constructor");
	}
	
	public  String generateMessage(String user) {
		System.out.println("WishMessageGenerator.generateMessage(-)");
		 int hour=0;
		 
		 //get current hour of the day
		 hour=date.getHour();  //24 hours format
		 if(hour<12)
			 return "Good Morning ::"+user;
		 else if(hour<16)
			 return "Good afernoon ::"+user;
		 else if(hour<20)
			 return "Good Evening ::"+user;
		 else 
			 return "Good Night ::"+user;
	}

}
