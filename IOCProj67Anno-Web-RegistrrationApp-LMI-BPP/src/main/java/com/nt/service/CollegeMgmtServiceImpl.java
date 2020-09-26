package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dao.IStudentDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;

@Service("clgService")
@Scope("singleton")
public abstract class CollegeMgmtServiceImpl implements ICollegeMgmtService {
	@Autowired
	private IStudentDAO stDAO;
	@Autowired
	private IEmployeeDAO empDAO;
	
	@Lookup
	public abstract StudentBO  fetchStudentBO();
	@Lookup
	public abstract EmployeeBO  fetchEmployeeBO();

	public CollegeMgmtServiceImpl() {
		System.out.println("CollegeMgmtServiceImpl: 0-param constructor"+this.getClass());
	}

	
	
	@Override
	public String enrollStudent(StudentDTO dto) throws Exception {
		int total=0;
		float avg=0.0f;
		StudentBO bo=null;
		int count=0;
		//write b.logic
		total =dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		//get StudentBO class object
		bo=fetchStudentBO();
		//convert dto to bo and also put addtional data..
		BeanUtils.copyProperties(dto,bo); //matching names properties will copy
		bo.setTotal(total); bo.setAvg(avg);
		//use StudentDAO
		count=stDAO.registerStudent(bo);
		return (count==0)?"Student not Registered":"Student registered ";
	}

	@Override
	public String enrollEmployee(EmployeeDTO dto) throws Exception {
		float gSalary=0.0f, netSalary=0.0f;
		EmployeeBO  bo=null;
		int count=0;
		//b.logic
		gSalary=dto.getSalary()+(dto.getSalary()*0.4f);
		netSalary=gSalary-(gSalary*0.2f);
		// get  EmployeeBO object
		bo=fetchEmployeeBO();
		//copy dto to bo and also addtional data
		BeanUtils.copyProperties(dto, bo);
		bo.setGrossSalary(gSalary);
		bo.setNetSalary(netSalary);
		//use EmployeeDAO
		count=empDAO.registerEmployee(bo);
		return (count==0)?"Employee registration failed":"Employee registration succeded";
	}

}
