package com.nt.service;

public interface IBankService {
    public  String  withdrawMoney(long acno, double amount);
    public  String  depositeMoney(long acno, double amount);
}
