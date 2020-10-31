package com.nt.service;

import java.util.List;

import com.nt.dto.BankAccountDTO;

public interface IBankMgmtService {
    public  List<BankAccountDTO> fetchBankAccountsBySalRange(float start,float end);
    public  BankAccountDTO  fetchBankAccountByAcno(long acno);
    public   String  addBonusToAccountsByBalance(float bonus,float maxBalance);
}
