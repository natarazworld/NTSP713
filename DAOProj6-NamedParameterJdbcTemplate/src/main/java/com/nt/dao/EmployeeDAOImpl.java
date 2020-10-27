package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String  GET_EMPNAME_BY_NO="SELECT ENAME FROM EMP WHERE EMPNO=:no";
	private static final String  GET_EMPDETAILS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE  JOB IN(:desg1,:desg2,:desg3)";
	private static final String  INSERT_EMPLOYEE="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(:empNo,:ename,:job,:sal)";
	
	@Autowired
	private  NamedParameterJdbcTemplate npjt;

	@Override
	public String getEnameByNo(int no) {
		/*Map<String,Object> paramMap=new HashMap();
		paramMap.put("no",no);*/
		Map<String,Object> paramMap=Map.of("no",no);  //java9 feature
		
		String name=npjt.queryForObject(GET_EMPNAME_BY_NO, 
				                                                   paramMap, 
				                                                   String.class);
		return name;
	}//method

	@Override
	public List<EmployeeBO> getEmpDetailsByDesgs(String desg1, String desg2, String desg3) {
	   
		//prepare MapSqlParameterSource obj having the names,values of the named parameters
		MapSqlParameterSource  msps=new MapSqlParameterSource();
		msps.addValue("desg1",desg1); //namedparam, value
		msps.addValue("desg2",desg2);
		msps.addValue("desg3",desg3);
		List<EmployeeBO> listBO=npjt.query(GET_EMPDETAILS_BY_DESGS,
				                                                        msps,
				                                                        rs->{
				                                                        	List<EmployeeBO> listBO1=new ArrayList();
				                                                        	while(rs.next()) {
				                                                        		EmployeeBO bo=new EmployeeBO();
				                                                        		bo.setEmpNo(rs.getInt(1));
				                                                        		bo.setEname(rs.getString(2));
				                                                        		bo.setJob(rs.getString(3));
				                                                        		bo.setSal(rs.getFloat(4));
				                                                        		listBO1.add(bo);
				                                                        	}//while
				                                                        	return listBO1;
				                                                        });
		
		return listBO;
	}//method
	
	@Override
	public int insertEmployee(EmployeeBO bo) {
		//create BeanPropertySqlParameterSource object
		BeanPropertySqlParameterSource bpsps=new BeanPropertySqlParameterSource(bo);
		//execute query
		int count=npjt.update(INSERT_EMPLOYEE, bpsps);
		return count;
	}

}//class
