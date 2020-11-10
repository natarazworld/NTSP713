package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("mysqlCustDAO")
@Profile({"dev","test"})
public  class MysqlCustomerDAOImpl implements CustomerDAO {
	private  static final  String   CUSTOMER_INSERT_QUERY="INSERT INTO SPRING_CUSTOMER(CNAME,CADD,PAMT,INTRAMT) VALUES(?,?,?,?)";
	
	@Autowired
	private  JdbcTemplate jt;
	
	public MysqlCustomerDAOImpl() {
		System.out.println("MysqlCustomerDAOImpl::0-param constructor");
	}
	

	@Override
	public int insert(CustomerBO bo) throws Exception {
		System.out.println("MysqlCustomerDAOImpl.insert(-):: "+jt.getDataSource().getClass());
	  int count=jt.update(CUSTOMER_INSERT_QUERY,
			                              bo.getCname(),bo.getCadd(),bo.getPamt(),bo.getIntramt());
	  return count;
  }

}
