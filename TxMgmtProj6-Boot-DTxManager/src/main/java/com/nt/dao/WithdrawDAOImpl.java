package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("withdrawDAO")
public class WithdrawDAOImpl implements IWithdrawDAO {
	private static final String  WITHDRAW_QUERY="UPDATE DTX_ACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
	@Autowired
	@Qualifier("oracleTemplate")
	private  JdbcTemplate oraJt;

	@Override
	public int withdraw(long acno, double amount) {
		int count=0;
		count=oraJt.update(WITHDRAW_QUERY, amount,acno);
		return count;
	}

}
