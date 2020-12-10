package com.nt.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IBankDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {
	
	@Autowired
	private   IBankDAO dao;
		

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false,timeout = 10,rollbackFor = java.sql.SQLException.class)
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
