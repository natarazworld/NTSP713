//ICustomerInfoRepo.java
package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CustomerInfo;

public interface ICustomerInfoRepo extends JpaRepository<CustomerInfo,Integer> {

}
