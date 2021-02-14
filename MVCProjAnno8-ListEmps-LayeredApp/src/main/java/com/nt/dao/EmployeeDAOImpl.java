package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String  GET_ALL_EMPS_QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	@Autowired
	private  JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getAllEmployees() {
		List<EmployeeBO> listBO=jt.query(GET_ALL_EMPS_QUERY, new EmployeeExtractor());
		return listBO;
	}
	
	//nested inner class (static inner class) 
	private  static class EmployeeExtractor implements ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			//convert RS into ListBO
			List<EmployeeBO>  listBO=new ArrayList();
			while(rs.next()) {
				EmployeeBO bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				listBO.add(bo);
			}
			
			return listBO;
		}
		
	}//inner class
}//class
