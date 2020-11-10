package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;
import com.nt.vo.CustomerVO;

@Controller("controller")
public  final class MainController {
	@Autowired
	private CustomerMgmtService service;
 
	
	public  String  processCustomer(CustomerVO  vo)throws Exception{
		CustomerDTO dto=null;
		String result=null;
		//convert  VO class object to DTO class object
		dto=new CustomerDTO();
		dto.setCname(vo.getCname());
		dto.setCadd(vo.getCadd());
		dto.setPamt(Float.parseFloat(vo.getpAmt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		//use service
		result=service.calculateIntrestAmount(dto);
		return result;
		
	}
	
	

}
