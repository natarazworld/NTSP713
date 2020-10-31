package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("authDAO")
public class AuthenticationDAOImpl implements IAuthenticationDAO {
	@Autowired
	private SimpleJdbcCall sjc;

	@Override
	public String authentication(String user, String pwd) {
		//set procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//prepare Map of IN Params
		Map<String,?> inParams=Map.of("USERNAME",user,"PASSWORD",pwd);  //java 9 feature
		//call PL/SQL procedure
		Map<String,?> outParams=sjc.execute(inParams);
		return (String) outParams.get("RESULT");
	}

}
