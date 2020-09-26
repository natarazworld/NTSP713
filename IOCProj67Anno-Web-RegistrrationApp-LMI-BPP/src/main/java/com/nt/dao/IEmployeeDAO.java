package com.nt.dao;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {
    public   int  registerEmployee(EmployeeBO bo)throws Exception;
}
