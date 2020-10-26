package com.nt.service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<StudentDTO> fetchStudentsByCities(String city1, String city2, String city3) {
		List<StudentBO> listBO=null;
		List<StudentDTO> listDTO=new ArrayList();
		//use SErvice
		listBO=dao.getStudentsByCities(city1, city2, city3);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			StudentDTO dto=new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			if(bo.getAvg()>=75)
				dto.setGrade("First class with Distinction");
			else if(bo.getAvg()>=60)
				dto.setGrade("First class ");
			else if(bo.getAvg()>=50)
				dto.setGrade("second class");
			else if(bo.getAvg()>=35)
				dto.setGrade("pass");
			else
				dto.setGrade("FAIL");
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//nethod
	
	@Override
	public List<StudentDTO> fetchStudentsByCities1(String city1, String city2, String city3) {
		List<StudentBO> listBO=null;
		List<StudentDTO> listDTO=new ArrayList();
		//use SErvice
		listBO=dao.getStudentsByCities1(city1, city2, city3);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			StudentDTO dto=new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			if(bo.getAvg()>=75)
				dto.setGrade("First class with Distinction");
			else if(bo.getAvg()>=60)
				dto.setGrade("First class ");
			else if(bo.getAvg()>=50)
				dto.setGrade("second class");
			else if(bo.getAvg()>=35)
				dto.setGrade("pass");
			else
				dto.setGrade("FAIL");
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//methnod

}
