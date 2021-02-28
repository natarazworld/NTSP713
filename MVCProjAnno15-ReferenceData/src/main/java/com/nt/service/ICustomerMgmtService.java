package com.nt.service;

import java.util.List;
import java.util.Set;

import com.nt.model.Customer;

public interface ICustomerMgmtService {
     public  String  register(Customer cust);	
     public Set<String>  fetchAllCountries();
     public Set<String>  fetchAllLaguages();
}
