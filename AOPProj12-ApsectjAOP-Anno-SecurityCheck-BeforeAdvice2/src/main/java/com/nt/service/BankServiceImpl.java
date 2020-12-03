package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IBankDAO;
@Service("bankService")
public class BankServiceImpl implements IBankService {
	@Autowired
	private  IBankDAO  dao;
	
	
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
