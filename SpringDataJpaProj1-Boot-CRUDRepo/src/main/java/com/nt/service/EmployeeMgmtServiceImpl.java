package com.nt.service;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private  IEmployeeRepo  empRepo;

	@Override
	public int registerEmployee(EmployeeDTO dto) {
		//convert  dto to Entity
		Employee entity=new Employee();
		BeanUtils.copyProperties(dto, entity);
		System.out.println(empRepo.getClass()+" "+Arrays.toString(empRepo.getClass().getInterfaces())+"  "+Arrays.toString(empRepo.getClass().getDeclaredMethods()));
		//use  empRepo
		/*Employee entity1=empRepo.save(entity);
		return entity1.getEno();*/
		return  empRepo.save(entity).getEno();
	}

}
