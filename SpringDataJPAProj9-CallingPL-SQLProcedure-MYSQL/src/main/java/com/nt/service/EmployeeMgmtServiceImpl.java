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
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_EMPS_BY_CITIES`(IN city1 varchar(10), IN city2 varchar(10))
			BEGIN
			   SELECT ENO,ENAME,EADD,ESALARY FROM  EMPLOYEE WHERE EADD IN(city1,city2);
			END
	*/
	@Override
	public List<EmployeeDTO> fetchEmpsByCities(String city1, String city2) {
		//create StoredProcedureQuery object
		StoredProcedureQuery procedure=em.createStoredProcedureQuery("P_GET_EMPS_BY_CITIES", Employee.class);
		//register Prcodure  Parameters
		procedure.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
		procedure.registerStoredProcedureParameter(2, String.class,ParameterMode.IN);
		//set values to  IN params
		procedure.setParameter(1, city1);
		procedure.setParameter(2,city2);
		//execute PL/SQL procedure
		List<Employee> listEntities=procedure.getResultList();
		//convert  listEntities  to listDTO
		List<EmployeeDTO>  listDTO=new ArrayList();
		listEntities.forEach(entity->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTO.add(dto);
		});
		
		return  listDTO;
	}//method
}//class
