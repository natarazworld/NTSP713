package com.nt.dao;

public interface IBankDAO {
   public int  withdraw(long acno,double amout);
   public  int  deposite(long acno,double amount);
}
