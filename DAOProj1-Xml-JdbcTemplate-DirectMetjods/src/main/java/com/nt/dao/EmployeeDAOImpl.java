package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	private  static final String  GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	private  JdbcTemplate jt;

	public EmployeeDAOImpl(JdbcTemplate jt) {
		 this.jt=jt;
	}
	
	@Override
	public int getEmpsCount() {
       int count=0;
        count=jt.queryForObject(GET_EMPS_COUNT,Integer.class);
        return count;
	}

}
