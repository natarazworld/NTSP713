package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.BankAccountBO;

@Repository("bankDAO")
public class BankAccountDAOImpl implements IBankAccountDAO {
	@Autowired
	private  SimpleJdbcInsert sjc;

	/*@Override
	public int register(BankAccountBO bo) {
		//prepare Map object having  col names and value
		Map<String,Object>  map=Map.of("acno", bo.getAcno(), "holderName", bo.getHolderName(), "balance", bo.getBalance(), "status",bo.getStatus()); //java9 feature
		//set db table name
		sjc.setTableName("BANK_ACCOUNT");
		//execute  query by generating the query dynamically
		int  count=sjc.execute(map);
		return count;
	}*/
	
	
	@Override
	public int register(BankAccountBO bo) {
		//prepare BeanPropertySqlParameterSource  object having  BO class obj (here col names must match bo class property names)
           BeanPropertySqlParameterSource bpsps=new BeanPropertySqlParameterSource(bo);
		//set db table name
		sjc.setTableName("BANK_ACCOUNT");
		//execute  query by generating the query dynamically
		int  count=sjc.execute(bpsps);
		return count;
	}

}
