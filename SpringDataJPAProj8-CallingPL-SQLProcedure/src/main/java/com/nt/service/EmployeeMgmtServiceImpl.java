package com.nt.service;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private  EntityManager em;
	
	
	/*CREATE OR REPLACE PROCEDURE P_GET_EMPS_BY_SALRANGE 
	(
	  STARTSALARY IN NUMBER 
	, ENDSALARY IN NUMBER 
	, DETAILS OUT SYS_REFCURSOR 
	) AS 
	BEGIN
	  
	  OPEN DETAILS FOR
	      SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE ESALARY>=STARTSALARY  AND ESALARY<=ENDSALARY;
	    
	END ;  */

	@Override
	public List<EmployeeDTO> fetchEmpsBySalaryRange(float startSalary, float endSalary) {
		//create StoredProcedureQuery Object
		StoredProcedureQuery procedure=em.createStoredProcedureQuery("P_GET_EMPS_BY_SALRANGE",Employee.class);
		//register  PL/SQL Procedure  Parameters 
		procedure.registerStoredProcedureParameter(1, Float.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(2, Float.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(3, Employee.class, ParameterMode.REF_CURSOR);
		//set values to IN params
		procedure.setParameter(1, startSalary);  //startSalary
		procedure.setParameter(2,endSalary);  //endSalary
		//call PL/SQL procedure
		List<Employee> listEntities=procedure.getResultList();
		//convert listEntities to listDTO
		List<EmployeeDTO>  listDTO=new ArrayList();
		listEntities.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(entity,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
	
	/*CREATE OR REPLACE PROCEDURE P_GET_EMPS_BY_CITIES 
	(
	  CITY1 IN VARCHAR2 
	, CITY2 IN VARCHAR2 
	, DETAILS OUT SYS_REFCURSOR 
	) AS 
	BEGIN
	  OPEN DETAILS FOR
	  SELECT ENO,ENAME,EADD  FROM EMPLOYEE WHERE  EADD IN(CITY1,CITY2);
	  
	END P_GET_EMPS_BY_CITIES; */
	
	@Override
	public List<Object[]> fetchEmpsDataByCities(String city1, String city2) {
		//create StoredProcedureQuery object
		StoredProcedureQuery procedure=em.createStoredProcedureQuery("P_GET_EMPS_BY_CITIES");
		//register parmaeters
		procedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(3, Object[].class, ParameterMode.REF_CURSOR);
		//set values to IN params
		procedure.setParameter(1,city1);
		procedure.setParameter(2, city2);
		//call PL/SQL procedure
		List<Object[]> list=procedure.getResultList();
		return list;
	}

	/*CREATE OR REPLACE FUNCTION FX_AUTHENTICATION( UNAME IN VARCHAR2 , PWD IN VARCHAR2) RETURN VARCHAR2 AS 
	   CNT NUMBER(5);
	   RESULT VARCHAR2(20);
	BEGIN
	
	   SELECT COUNT(*) INTO CNT  FROM USERSLIST WHERE USERNAME=UNAME AND PASSWORD=PWD;
	   IF(CNT<>0) THEN
	     RESULT:='VALID CREDENTIALS';
	   ELSE    
	     RESULT:='INVALID CREDENTIALS'; 
	   END IF;  
	  RETURN RESULT;
	END FX_AUTHENTICATION;
	*/	
	
	@Override
	public String authenticate(String username, String password) {
		//unwrap Session obj from Entity Manager
	 	Session ses=em.unwrap(Session.class);
	 	 // write JDBc code
	 	String result=ses.doReturningWork(con->{
	 		try {
	 		//create CallableStatemene object
	 			CallableStatement cs=con.prepareCall("{?=call FX_AUTHENTICATION(?,?)}");
	 			//register  return parameter with JDBC type
	 			cs.registerOutParameter(1,Types.VARCHAR); //return param
	 			//set values to IN params
	 			cs.setString(2,username);
	 			cs.setString(3,password);
	 			//call PL/SQL function
	 			cs.execute();
	 			//get result from Return params
	 			String  output=cs.getString(1);
	 			return output;
	 		}//try
	 		catch(SQLException se) {
	 			se.printStackTrace();
	 			return null;
	 		}
	 	});
		return result;
	}//method
	
	
	
}//class
