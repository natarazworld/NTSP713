package com.nt.dao;

public interface IBankDAO {
    public   int withdraw(long acno, double amount);
    public   int deposite(long acno, double amount);
    
}
