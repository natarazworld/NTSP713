package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
     private  EmployeeDAO  dao;
     
	

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
