//ICustomerInfoMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.dto.CustomerInfoDTO;

public interface ICustomerInfoMgmtService {
     public    String  registerCustomer(CustomerInfoDTO dto);
     public   List<CustomerInfoDTO>  fetchAllCustomerDetails();
}
