package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
     public   List<EmployeeDTO>  fetchEmpsBySalaryRange(float sartSalary,float endSalary);
     public   List<Object[]>  fetchEmpsDataByCities(String city1,String city2);
     public    String    authenticate(String username,String password);
     
}
