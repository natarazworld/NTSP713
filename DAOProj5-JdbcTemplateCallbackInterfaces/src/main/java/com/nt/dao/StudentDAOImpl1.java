package com.nt.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

//@Repository("studDAO")
public class StudentDAOImpl1 implements StudentDAO {
	private static final String  GET_STUDENT_BY_NO="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SNO=?" ;
	private static final String  GET_STUDENTS_BY_CITIES="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SADD IN(?,?,?)" ;
	@Autowired
	private  JdbcTemplate jt;

	@Override
	public StudentBO getStudentByNo(int no) {
		StudentBO bo=null;
		bo=jt.queryForObject(GET_STUDENT_BY_NO,   // arg1
				                             new RowMapper<StudentBO>() {
												@Override
												public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
                                                      StudentBO bo=null;
                                                      bo=new StudentBO();
                                                      bo.setSno(rs.getInt(1));
                                                      bo.setSname(rs.getString(2));
                                                      bo.setSadd(rs.getString(3));
                                                      bo.setAvg(rs.getFloat(4));
                                                      return bo;
												}//mapRow(-,-)
	                                        	}//anonymous inner class   //arg2
		                                        ,
				                              no //arg3 
				                              );
		return bo;
	} //method

	@Override
	public List<StudentBO> getStudentsByCities(String city1, String city2, String city3) {
		List<StudentBO> listBO=null;
		listBO=jt.query(GET_STUDENTS_BY_CITIES,  //arg1
				                        new ResultSetExtractor<List<StudentBO>>() {
											@Override
											public List<StudentBO> extractData(ResultSet rs)throws SQLException{
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
											}//extratData(-)
		                                },  // anonymous inner class arg2
				                        city1,city2,city3  //args3 (var args)
				                        );
		return listBO;
	}//method

	@Override
	public List<StudentBO> getStudentsByCities1(String city1, String city2, String city3) {
	    List<StudentBO> listBO=new ArrayList();
	    jt.query(GET_STUDENTS_BY_CITIES,
	    		                  new RowCallbackHandler() {
	    	                                 @Override
	    	                                public void processRow(ResultSet rs) throws SQLException {
	    	                                	 System.out.println(
														"StudentDAOImpl1.getStudentsByCities1(...).new RowCallbackHandler() {...}.processRow()");
	    	                                	//get each record into StudentBO class object
	    	                                	 StudentBO bo=new StudentBO();
	    	                     				bo=new StudentBO();
	    	                     				bo.setSno(rs.getInt(1));
	    	                     				bo.setSname(rs.getString(2));
	    	                     				bo.setSadd(rs.getString(3));
	    	                     				bo.setAvg(rs.getFloat(4));
	    	                     				//add each BO class obj to List colleciton
	    	                     				listBO.add(bo);	                                	
	    	                                }
                                    	    },
	    		                       city1,city2,city3);
		return listBO;
	}
	
	
}//outer class
