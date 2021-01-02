package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

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
	
}//class
