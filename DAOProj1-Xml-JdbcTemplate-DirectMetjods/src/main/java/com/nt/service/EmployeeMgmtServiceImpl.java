package com.nt.service;

import com.nt.dao.EmployeeDAO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
   private  EmployeeDAO dao;
 
   
    
public EmployeeMgmtServiceImpl(EmployeeDAO dao) {
	this.dao = dao;
}


	@Override
	public int fetchEmpsCount() {
		//use dao
		return dao.getEmpsCount();
	}

}
