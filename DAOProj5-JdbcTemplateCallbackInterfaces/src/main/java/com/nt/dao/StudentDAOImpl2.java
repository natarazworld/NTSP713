package com.nt.dao;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

//@Repository("studDAO")
public class StudentDAOImpl2 implements StudentDAO {
	private static final String  GET_STUDENT_BY_NO="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SNO=?" ;
	@Autowired
	private  JdbcTemplate jt;

	@Override
	public StudentBO getStudentByNo(int no) {
		StudentBO bo1=null;
		bo1=jt.queryForObject(GET_STUDENT_BY_NO,   // arg1
												  (rs, rowNum)->{
                                                      StudentBO bo=null;
                                                      bo=new StudentBO();
                                                      bo.setSno(rs.getInt(1));
                                                      bo.setSname(rs.getString(2));
                                                      bo.setSadd(rs.getString(3));
                                                      bo.setAvg(rs.getFloat(4));
                                                      return bo;
												  }//mapRow(-,-)
												  ,
				                              no //arg3 
				                              );
		return bo1;
	} //method
	
	
}//outer class
