package com.nt.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

//@Repository("studDAO")
public class StudentDAOImpl3 implements StudentDAO {
	private static final String  GET_STUDENT_BY_NO="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SNO=?" ;
	private static final String  GET_STUDENTS_BY_CITIES="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SADD IN(?,?,?)" ;
	@Autowired
	private  JdbcTemplate jt;

	@Override
	public StudentBO getStudentByNo(int no) {
		StudentBO bo1=null;
		bo1=jt.queryForObject(GET_STUDENT_BY_NO,   // arg1
												 new BeanPropertyRowMapper<StudentBO>(StudentBO.class),
				                              no //arg3 
				                              );
		return bo1;
	} //method

	@Override
	public List<StudentBO> getStudentsByCities(String city1, String city2, String city3) {
		List<StudentBO> listBO=null;
		BeanPropertyRowMapper<StudentBO> bprm=null;
		//create BeanPropertyRowMapper class obj  that hepls to copy each record into  one BO class obj
		bprm=new BeanPropertyRowMapper<StudentBO>(StudentBO.class);
		listBO=jt.query(GET_STUDENTS_BY_CITIES, //arg1
				                  new RowMapperResultSetExtractor<StudentBO>(bprm), //args2
				                   city1,city2,city3 //arg3 (Var args)
				                    );
		
		return listBO;
	}

	@Override
	public List<StudentBO> getStudentsByCities1(String city1, String city2, String city3) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}//outer class
