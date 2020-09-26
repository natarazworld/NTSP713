package com.nt.service;

import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;

public interface ICollegeMgmtService {
	public  String  enrollStudent(StudentDTO dto)throws Exception;
	public  String  enrollEmployee(EmployeeDTO dto)throws Exception;



}
