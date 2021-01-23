package com.nt.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.nt.document.Customer;

public interface CustomerRepo extends MongoRepository<Customer, Integer> {
     public   List<Customer>  findByCadd(String cadd);
     public  List<Customer>  findByCnoBetween(int start,int end);
}
