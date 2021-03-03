package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateWishMessage() {
		//get System Date and time
		Calendar cal=Calendar.getInstance();
		//get current hour of the day
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		//generates wish Message
		if(hour<12)
			return "Good Morning ";
		else if(hour<16)
			return "Good afternoon ";
		else if(hour<20)
			return "Good evening ";
		else
			return  "Good  Night";
	}//method
}//class
