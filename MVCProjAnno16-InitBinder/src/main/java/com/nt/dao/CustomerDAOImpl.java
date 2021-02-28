package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Customer;

@Repository("custDAO")
public class CustomerDAOImpl implements ICustomerDAO {
	private  static final String  CUSTOMER_INSERT_QUERY="INSERT INTO MVC_CUSTOMER VALUES(CNO_SEQ1.NEXTVAL,?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int insert(Customer cust) {
		//insert record
		int count=jt.update(CUSTOMER_INSERT_QUERY,cust.getCname(),cust.getCadd(),cust.getBillAmt());
		return count;
	}

}
