package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.CustomerDTO;

public interface ICustomerMgmtService {
    public   String  registerOrUpdateCustomer(CustomerDTO dto);
    public  List<CustomerDTO>  fetchAllCustomers();
    public  Optional<CustomerDTO>  fetchCustomerByCno(int cno);
    public   List<CustomerDTO>  fetchCustomersByCadd(String cadd);
    public   List<CustomerDTO>  fetchCustomersByCnoRange(int start,int end);
    
}
