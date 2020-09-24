package com.cb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cb.service.ICrickBuzzScoreMgmtService;

@WebServlet(value="/controller",loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
	private  ApplicationContext ctx;
	@Override
	public void init() throws ServletException {
		ctx=new  ClassPathXmlApplicationContext("com/cb/cfgs/applicationContext.xml");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int mid=0;
		ICrickBuzzScoreMgmtService service=null;
		String score=null;
		RequestDispatcher rd=null;
		//read  addtional req param value
		mid=Integer.parseInt(req.getParameter("mid"));
		//get Local Service class obj
		service=ctx.getBean("cbService",ICrickBuzzScoreMgmtService.class);
		//use Local service
		score=service.fetchScore(mid);
		//keep score in request scope
		req.setAttribute("scoreInfo",score);  // attr name, value
		//forward to result.jsp
		rd=req.getRequestDispatcher("/result.jsp");
		rd.forward(req, res);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
	
	@Override
	public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}
	

}
