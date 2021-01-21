package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Customer;

public interface CustomerRepo extends MongoRepository<Customer, String> {

}
