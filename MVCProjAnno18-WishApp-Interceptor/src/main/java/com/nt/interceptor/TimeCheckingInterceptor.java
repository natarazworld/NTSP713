//TimeCheckingInterceptor.java
package com.nt.interceptor;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("tci")
public class TimeCheckingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		// get System date and time
		LocalDateTime  sysDate=LocalDateTime.now();
		// get current current hour of the day
		int hour=sysDate.getHour();
		//write pre logics
		if(hour<9 || hour>17) {
			RequestDispatcher  rd=req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		else {
		   return true;
		}
	}

}
