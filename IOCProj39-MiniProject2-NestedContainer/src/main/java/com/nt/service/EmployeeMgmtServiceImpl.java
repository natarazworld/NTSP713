package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
     private  EmployeeDAO  dao;
     
	public EmployeeMgmtServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String desg1, String desg2, String desg3)throws Exception {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO>  listDTO=null;
		EmployeeDTO dto=null;
		//convert inputs(desgs) to uppercase letter  (b.logic)
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		//use DAO
		listBO=dao.getAllEmpsByDesgs(desg1, desg2, desg3);
		//convert listBO to listDTO
		  listDTO=new ArrayList();
		  for(EmployeeBO bo: listBO) {
			  //copy each bo to new DTO object
			 dto=new EmployeeDTO();
			 BeanUtils.copyProperties(bo, dto); // copies data from one javabean object to anthoer bean obj when they have matching properties names,types
			 dto.setSal((float) Math.round(bo.getSal())); //converts 7000.56 to 7001.0
			 dto.setSerialNo(listDTO.size()+1);  //serinal number generation..
			 //add each DTO 
			 listDTO.add(dto);
		  }//for
		  
		return listDTO;
	}//method
}//class
