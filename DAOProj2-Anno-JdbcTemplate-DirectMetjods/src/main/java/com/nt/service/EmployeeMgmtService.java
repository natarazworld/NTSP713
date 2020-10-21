package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmployeeMgmtService {
     public   int fetchEmpsCount();
     public   String fetchEmpNameByNo(int no);
     public   Map<String,Object> fetchEmpDetailsByNo(int no);
     public List<Map<String,Object>> fetchEmpDetailsByDesgs(String desg1,String desg2);
     public String registerEmp(String name,String desg,float salary);
     public  String putBonusToEmpByDesg(String desg,float bonus); 
}
