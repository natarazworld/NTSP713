package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private   IEmployeeRepo empRepo;

	@Override
	@Transactional
	public EmployeeDTO fetchEmployeeById(int eno) {
		//use   repo
		Employee entity=empRepo.getOne(eno);
		//convert entity to DTO
		EmployeeDTO dto=new EmployeeDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<EmployeeDTO> fetchEmployeesExampleData(EmployeeDTO dto,String property , boolean asc) {
		//convert  DTO to Entity
		Employee entity=new Employee();
		BeanUtils.copyProperties(dto,entity);
		//prepare Example object
		Example<Employee>  ex=Example.of(entity);
		//use repo
		List<Employee> listEntities=empRepo.findAll(ex,
				                                                                     asc?Sort.by(Direction.ASC,property):Sort.by(Direction.DESC, property));
        //convert to  ListEntities to   ListDTO
		List<EmployeeDTO>  listDTO=new ArrayList();
		listEntities.forEach(entity1->{
			EmployeeDTO dto1=new EmployeeDTO();
			BeanUtils.copyProperties(entity1, dto1);
			listDTO.add(dto1);
		});
		return listDTO;
	}//method

	@Override
	public void removeEmployeesInBatch(List<EmployeeDTO> listDTO) {
		
		//convert  ListDTO to ListEntities
		List<Employee> listEntities=new ArrayList();
		listDTO.forEach(dto->{
			Employee entity=new Employee();
			BeanUtils.copyProperties(dto, entity);
			listEntities.add(entity);
		});
		//use repo
		empRepo.deleteInBatch(listEntities);
		
	}

}//class
