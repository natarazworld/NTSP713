package com.nt.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("studDAO")
public class StudentDAOImpl2 implements StudentDAO {
	private static final String  GET_STUDENT_BY_NO="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SNO=?" ;
	private static final String  GET_STUDENTS_BY_CITIES="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SADD IN(?,?,?)" ;
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

	@Override
	public List<StudentBO> getStudentsByCities(String city1, String city2, String city3) {
		List<StudentBO> listBO1=null;
		listBO1=jt.query(GET_STUDENTS_BY_CITIES, //agrg1
				                   rs->{
				                	   List<StudentBO>  listBO=null;
										StudentBO bo=null;
										//copy  RS object records to  List of StudentBO collection
										listBO=new ArrayList();
										while(rs.next()) {
											//get each record into StudentBO class object
											bo=new StudentBO();
											bo.setSno(rs.getInt(1));
											bo.setSname(rs.getString(2));
											bo.setSadd(rs.getString(3));
											bo.setAvg(rs.getFloat(4));
											//add each BO class obj to List colleciton
											listBO.add(bo);
										}//while
										return listBO;   
				                   }, //args
				                   city1,city2,city3 // arg3(var ..args)
				                 );//method
		return listBO1;
	}//method

	@Override
	public List<StudentBO> getStudentsByCities1(String city1, String city2, String city3) {
		List<StudentBO> listBO=new ArrayList();
		jt.query(GET_STUDENTS_BY_CITIES,rs->{
			//get each record into StudentBO class object
			System.out.println("StudentDAOImpl2.getStudentsByCities1()...lAMDA...");
			StudentBO bo=new StudentBO();
			bo.setSno(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSadd(rs.getString(3));
			bo.setAvg(rs.getFloat(4));
			//add each BO class obj to List colleciton
			listBO.add(bo);
			
		                                 },
				                       city1,city2,city3);
		return listBO;
	}
	
	
}//outer class
