package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.EmployeeDAO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
   private  EmployeeDAO dao;
 
	@Override
	public int fetchEmpsCount() {
		//use dao
		return dao.getEmpsCount();
	}
	
	@Override
		public String fetchEmpNameByNo(int no) {
			return dao.getEmpNameByNo(no);
		}
	
	@Override
		public Map<String, Object> fetchEmpDetailsByNo(int no) {
			return dao.getEmpDetailsByNo(no);
		}
	
	@Override
		public List<Map<String, Object>> fetchEmpDetailsByDesgs(String desg1, String desg2) {
			//use dAO
			return dao.getEmpDetailsByDesgs(desg1, desg2);
		}
	
	@Override
		public String registerEmp(String name, String desg, float salary) {
		int count=0;
		//use DAO
		  count=dao.insertEmp(name, desg, salary);
			return count==0?"Employee not registred":"employee registered";  //ternary operator
		}
	
	@Override
		public String putBonusToEmpByDesg(String desg, float bonus) {
		int count=0;
			//use dao
		count=dao.addBonusToEmpByDesg(desg, bonus);
			return count==0?desg+" employees not found to add bonus ":count+" no.of employees salary is added with bonus";
		}

}
