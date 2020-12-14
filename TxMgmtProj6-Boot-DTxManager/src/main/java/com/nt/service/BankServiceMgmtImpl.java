package com.nt.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IDepositeDAO;
import com.nt.dao.IWithdrawDAO;

@Service("bankService")
public class BankServiceMgmtImpl implements IBankServiceMgmt {
	@Autowired
	private IWithdrawDAO withdrawDAO;
	@Autowired
	private  IDepositeDAO depositeDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false,transactionManager = "jtaTxMgmr")
	public String transferMoney(long srcAcno, long destAcno, double amount) {
		 int count1=withdrawDAO.withdraw(srcAcno, amount);
		 int count2=depositeDAO.deposite(destAcno, amount);
		 if(count1==0 || count2==0)
			 throw new RuntimeException("Problem in Money transfering");
		 else
			 return "Money transffered from "+srcAcno+"  to "+destAcno;
	}

}
