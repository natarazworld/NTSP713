package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private   IEmployeeRepo empRepo;

	@Override
	public List<EmployeeDTO> getAllEmployees(String property, boolean asc) {
	/*	Sort sort=null;
		 if(asc==true) {
			  sort=Sort.by(org.springframework.data.domain.Sort.Direction.ASC,"ename");
		 }
		 else {
			  sort=Sort.by(org.springframework.data.domain.Sort.Direction.DESC,"ename");
		 }
		 List<Employee> listEntities=(List<Employee>) empRepo.findAll(sort); */
		 
		//use  Repo
		List<Employee> listEntities=(List<Employee>) empRepo.findAll(asc?Sort.by(Sort.Direction.ASC, property): 
			                                                                                                         Sort.by(Sort.Direction.DESC,property));
		//convert  listEntities to listDTos
		List<EmployeeDTO> listDTOs=new ArrayList();
		listEntities.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTOs.add(dto);
		});
		return  listDTOs;
	}

}
