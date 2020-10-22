package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

@Service("studService")
public class StudentMgmtServiceImpl implements StudentMgmtService {
	@Autowired
	private  StudentDAO dao;

	@Override
	public StudentDTO fetchStudentByNo(int no) {
       	StudentBO bo=null;	
       	StudentDTO dto=null;
		//use DAO
       	bo=dao.getStudentByNo(no);
       	//convert BO to DTO
       	dto=new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

}
