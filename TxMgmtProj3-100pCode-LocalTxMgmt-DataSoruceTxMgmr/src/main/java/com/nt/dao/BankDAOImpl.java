package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDAO")
public class BankDAOImpl implements IBankDAO {
	private  static final  String WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE  ACNO=?";
	private  static final  String DEPOSITE_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE  ACNO=?";
	
	@Autowired
	private  JdbcTemplate jt;


	@Override
	public int withdraw(long acno, double amount) {
	  int count=jt.update(WITHDRAW_QUERY, amount,acno);
		return count;
	}

	@Override
	public int deposite(long acno, double amount) {
		int count=jt.update(DEPOSITE_QUERY, amount,acno);
		return count;
	}

}
