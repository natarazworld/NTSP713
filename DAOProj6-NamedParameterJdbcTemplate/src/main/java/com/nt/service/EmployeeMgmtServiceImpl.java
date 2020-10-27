package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
       private IEmployeeDAO  dao;
	
	@Override
	public String fetchEmpNameByNo(int no) {
	   //use dAO
		String name=dao.getEnameByNo(no);
		return name;
	}

	@Override
	public List<EmployeeDTO> fetchEmpDetailsByDesgs(String desg1, String desg2, String desg3) {
		//use dAO
		List<EmployeeBO> listBO=dao.getEmpDetailsByDesgs(desg1, desg2, desg3);
		//convert  listBO to listDTO
		List<EmployeeDTO> listDTO=new ArrayList();
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
	
	@Override
	public String registerEmployee(EmployeeDTO dto) {
		//convert DTO to BO
		EmployeeBO bo=new EmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		int count=dao.insertEmployee(bo);
		return count==1?"Employee registered":"Employee Not registered";
	}
}//class
