package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
     public String  fetchEmpNameByNo(int no);
     public List<EmployeeDTO> fetchEmpDetailsByDesgs(String desg1,String desg2,String desg3);
     public String  registerEmployee(EmployeeDTO dto);
}
