package com.nt.controller;

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

import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;
import com.nt.service.ICollegeMgmtService;

@WebServlet(value="/controller", loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
	ApplicationContext ctx;
	public void init()  {
	  //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	}

	public void destroy() {
		//close IOC container
		((AbstractApplicationContext) ctx).close();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String type=null;
		StudentDTO  stDTO=null;
		EmployeeDTO  empDTO=null;
		ICollegeMgmtService service=null;
		String result=null;
		String targetPage=null;
		RequestDispatcher rd=null;
		//get SErvice class object
		service=ctx.getBean("clgService",ICollegeMgmtService.class);
	    //Evaluate which form is submitting request to diffrent the logics
		type=req.getParameter("type");
        //write logic		
		if(type.equalsIgnoreCase("registerStudent")) {
			//get StudentDTO class object
			stDTO=ctx.getBean("stDTO",StudentDTO.class);
			//read form data  and store  into   StudentDTO class obj
			stDTO.setId(Integer.parseInt(req.getParameter("sid")));
			stDTO.setName(req.getParameter("sname"));
			stDTO.setSadd(req.getParameter("sadd"));
			stDTO.setCourse(req.getParameter("course"));
			stDTO.setM1(Integer.parseInt(req.getParameter("m1")));
			stDTO.setM2(Integer.parseInt(req.getParameter("m2")));
			stDTO.setM3(Integer.parseInt(req.getParameter("m3")));
			try {
			//use Service
			result=service.enrollStudent(stDTO);
			//keep result in request scope
			req.setAttribute("resultMsg",result);
			targetPage="/show_result.jsp";
			}
			catch(Exception e) {
				targetPage="/error.jsp";
				e.printStackTrace();
			}
		}//if
		else {
			//get EmployeeDTO class object
			empDTO=ctx.getBean("empDTO",EmployeeDTO.class);
			//read form data  and store  into  EmployeeDTO class obj
			empDTO.setId(Integer.parseInt(req.getParameter("eid")));
			empDTO.setName(req.getParameter("ename"));
			empDTO.setCompany(req.getParameter("company"));
			empDTO.setSalary(Float.parseFloat(req.getParameter("esalary")));
			try {
			//use service
			result=service.enrollEmployee(empDTO);
			//keep result in request scope
			req.setAttribute("resultMsg",result);
			targetPage="/show_result.jsp";
			}
			catch(Exception e) {
				targetPage="/error.jsp";
				e.printStackTrace();
			}
		}//else
		//forward request to  target page (show_result.jsp or error.jsp)
		rd=req.getRequestDispatcher(targetPage);
		rd.forward(req, res);
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            doGet(req,res);
	}

}
