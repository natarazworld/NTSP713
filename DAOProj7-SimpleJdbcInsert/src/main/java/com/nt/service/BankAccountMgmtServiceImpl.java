package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.BankAccountDTO;
import com.nt.bo.BankAccountBO;
import  com.nt.dao.IBankAccountDAO;
@Service("bankService")
public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService {
	@Autowired
	private IBankAccountDAO dao;

	@Override
	public String openAccount(BankAccountDTO dto) {
		//convert dto to bo
		BankAccountBO bo=new BankAccountBO();
		BeanUtils.copyProperties(dto, bo);
		//use DAO
		int count=dao.register(bo);
		return count==1?"BankAccount Opened":"Bank Account not opened";
	}//method

}//class
