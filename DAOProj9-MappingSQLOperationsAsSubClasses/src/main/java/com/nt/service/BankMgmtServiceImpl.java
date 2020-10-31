package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.BankAccountBO;
import com.nt.dao.IBankDAO;
import com.nt.dto.BankAccountDTO;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {
	@Autowired
	private  IBankDAO dao;

	@Override
	public List<BankAccountDTO> fetchBankAccountsBySalRange(float start, float end) {
	   //use DAO
		List<BankAccountBO> listBO=dao.getBankAccountsByBalanceRange(start, end);
		//convert ListBO to ListDTO
		List<BankAccountDTO> listDTO=new ArrayList();
		listBO.forEach(bo->{
			BankAccountDTO dto=new BankAccountDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
	
	@Override
	public BankAccountDTO fetchBankAccountByAcno(long acno) {
		//use DAO
		BankAccountBO bo=dao.getBankAccountByAcno(acno);
		//convert BO to DTO
		BankAccountDTO dto=new BankAccountDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}//method
	
	@Override
	public String addBonusToAccountsByBalance(float bonus, float maxBalance) {
		//use DAO
		int count=dao.updateBankAccountWithBonusByBalance(bonus, maxBalance);
		return count+" number of accounts added with bonus::"+bonus;
	}//method

}//class
