package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import  org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private   IEmployeeRepo empRepo;

	@Override
	public List<EmployeeDTO> getAllEmployeesBySorting(String property, boolean asc) {
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

	@Override
	public List<EmployeeDTO> getAllEmployeesBySorting(boolean asc, String... properties) {
		//use  Repo
		List<Employee> listEntities=(List<Employee>) empRepo.findAll(asc?Sort.by(Direction.ASC, properties): 
			                                                                                                         Sort.by(Direction.DESC,properties));
		//convert  listEntities to listDTos
		List<EmployeeDTO> listDTOs=new ArrayList();
		listEntities.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTOs.add(dto);
		});
		return  listDTOs;
	}
	
	@Override
	public List<EmployeeDTO> getPageRecords(int pageNo, int pageSize) {
		//Prepared Pageable object having pageNo,pageSize
		Pageable pageable=PageRequest.of(pageNo, pageSize,Direction.ASC,"eno");
		//get Page<T> object 
		Page<Employee> page=empRepo.findAll(pageable);
		System.out.println(page.getNumber()+"  "+page.getNumberOfElements()+"  "+page.getTotalPages());
		System.out.println(page.isEmpty()+" "+page.isFirst()+" "+page.isLast());
		
		//get ListEntities from  Page<T> obj
		List<Employee> listEntities=page.getContent();
		//convert listEntities to ListDTOs
		List<EmployeeDTO> listDTO=new ArrayList();
		listEntities.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}
	
	@Override
	public void getRecordsByPagination(int pageSize) {
		//get total no.of records
		 long count=empRepo.count();
		 //get total no.of pages
		 int pagesCount=(int) (count/pageSize);
		 
		 if(count%pageSize!=0)
			  pagesCount++;
		  //display records  page by page
		 for(int i=0;i<pagesCount;++i) {
			 Pageable pageable=PageRequest.of(i, pageSize);
			 Page<Employee> page=empRepo.findAll(pageable);
			 List<Employee> listEntities=page.getContent();
			   listEntities.forEach(System.out::println);
			   System.out.println(page.getNumber()+1+" of"+page.getTotalPages());
			   System.out.println("---------------------------------------------");
		 }
		 
		 
		 
		
	}

}
