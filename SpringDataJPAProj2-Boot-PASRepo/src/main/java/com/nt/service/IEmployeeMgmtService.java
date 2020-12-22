package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
     public   List<EmployeeDTO>  getAllEmployeesBySorting(String property, boolean asc);
     public   List<EmployeeDTO>  getAllEmployeesBySorting(boolean asc,String ...properties);
     public   List<EmployeeDTO>  getPageRecords(int pageNo,int pageSize);
     public    void getRecordsByPagination(int pageSize);
     
}
