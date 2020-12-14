package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("depositeDAO")
public class DepositeDAOImpl implements IDepositeDAO {
	private static final String  DEPOSITE_QUERY="UPDATE DTX_ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
	@Autowired
	@Qualifier("mysqlTemplate")
	private  JdbcTemplate mysqlJt;

	@Override
	public int deposite(long acno, double amount) {
		int count=0;
		count=mysqlJt.update(DEPOSITE_QUERY, amount,acno);
		return count;
	}

}
