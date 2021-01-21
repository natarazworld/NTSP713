package com.nt.service;

import com.nt.dto.CustomerDTO;

public interface ICustomerMgmtService {
    public   String  registerCustomer(CustomerDTO dto);
    public   String  updateCustomer(CustomerDTO dto);
}
