package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
    public  int   getEmpsCount();
    public  String   getEmpNameByNo(int eno);
    public Map<String,Object>  getEmpDetailsByNo(int no);
    public  List<Map<String,Object>> getEmpDetailsByDesgs(String desg1,String desg2);
    public   int insertEmp(String name,String desg, float salary);
    public  int  addBonusToEmpByDesg(String desg,float bonus);
}
