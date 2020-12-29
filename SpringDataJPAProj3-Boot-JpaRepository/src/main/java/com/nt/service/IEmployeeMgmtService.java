package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
     public    EmployeeDTO   fetchEmployeeById(int eno);
     public    List<EmployeeDTO>  fetchEmployeesExampleData(EmployeeDTO dto,String property,boolean asc);
     public   void  removeEmployeesInBatch(List<EmployeeDTO> listDTO);
}
