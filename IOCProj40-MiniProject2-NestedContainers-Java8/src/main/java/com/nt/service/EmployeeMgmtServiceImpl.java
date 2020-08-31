package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
     private  EmployeeDAO  dao;
     private String type;
     
	public EmployeeMgmtServiceImpl(EmployeeDAO dao,String type) {
		System.out.println("container type::"+type);
		this.dao = dao;
		this.type=type;
	}

	@Override
	public String toString() {
		return "EmployeeMgmtServiceImpl [type=" + type + "]";
	}

	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String desg1, String desg2, String desg3)throws Exception {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO>  listDTO=new ArrayList();
		//convert inputs(desgs) to uppercase letter  (b.logic)
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		//use DAO
		listBO=dao.getAllEmpsByDesgs(desg1, desg2, desg3);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			//copy each bo to dto
			 EmployeeDTO dto=new EmployeeDTO();
			 BeanUtils.copyProperties(bo,dto);
			 dto.setSerialNo(listDTO.size()+1);
			 //add each dto listDTO
			 listDTO.add(dto);
		});
		
		  
		return listDTO;
	}//method
	
	
	
}//class
