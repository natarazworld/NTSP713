package com.nt.dao;

import java.util.List;

import com.nt.bo.BankAccountBO;

public interface IBankDAO {
      public   List<BankAccountBO>  getBankAccountsByBalanceRange(float start, float end);
      public   BankAccountBO  getBankAccountByAcno(long acno);
      public   int   updateBankAccountWithBonusByBalance(float bonus,float maxBalance);
}
