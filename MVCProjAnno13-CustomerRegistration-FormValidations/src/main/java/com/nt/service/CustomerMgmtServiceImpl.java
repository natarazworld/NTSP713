package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ICustomerDAO;
import com.nt.model.Customer;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private ICustomerDAO dao;

	@Override
	public String register(Customer cust) {
		//use DAO
		int count=dao.insert(cust);
		return (count==0)?"Customer Registration Failed":"Customer Registration succeded";
	}

}
