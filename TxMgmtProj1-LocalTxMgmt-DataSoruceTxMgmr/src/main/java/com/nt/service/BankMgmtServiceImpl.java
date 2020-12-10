package com.nt.service;

import java.sql.SQLException;

import com.nt.dao.IBankDAO;

public class BankMgmtServiceImpl implements IBankMgmtService {
	private   IBankDAO dao;
	

	public BankMgmtServiceImpl(IBankDAO dao) {
		this.dao = dao;
	}


	@Override
	public boolean transferMoney(long srcAcno, long destAcno, double amount)throws SQLException {
		boolean flag=false;
		/*	try {
				Thread.sleep(20000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
	     int count1=dao.withdraw(srcAcno, amount);
	     int count2=dao.deposite(destAcno, amount);
	     if(count1==0 || count2==0)
		       throw new SQLException("Problem in money transffering");
	     else
	    	 flag=true;
	     
	     return flag;
	}

}
