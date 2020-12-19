package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
    public    int   registerEmployee(EmployeeDTO dto);
    public    int[]  registerEmployeesGroup(List<EmployeeDTO> listDTO);
    public   long   getEmployeesCount();
    public   String  removeEmployeeById(int id); 
    public   Optional<EmployeeDTO>  getEmployeeById(int id);
    public   String  removeEmployeeById1(int id);
    public   Iterable<EmployeeDTO>  getAllEmployees();
    public  String  removeEmployeesByGivenEntities(List<EmployeeDTO> listDTOs);
     public   List<EmployeeDTO>   getEmployeesByIds(List<Integer> ids);
}
