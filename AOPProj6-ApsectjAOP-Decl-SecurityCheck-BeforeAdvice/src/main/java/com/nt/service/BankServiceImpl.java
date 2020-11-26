package com.nt.service;

import com.nt.dao.IBankDAO;

public class BankServiceImpl implements IBankService {
	private  IBankDAO  dao;
	
	public BankServiceImpl(IBankDAO dao) {
		this.dao = dao;
	}

	@Override
	public String withdrawMoney(long acno, double amount) {
	   int count=dao.withdraw(acno, amount);
	   return count==0?"Money not withdrawn":amount+" money is withdrawn from the account::"+acno;
	}

	@Override
	public String depositeMoney(long acno, double amount) {
		 int count=dao.deposite(acno, amount);
		   return count==0?"Money not deposited":amount+" money is deposited from the account::"+acno;
	}

}
