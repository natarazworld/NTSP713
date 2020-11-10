package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;
@Repository("oraCustDAO")
@Profile({"uat","prod"})
public final class OracleCustomerDAOImpl implements CustomerDAO {
	private  static final  String   CUSTOMER_INSERT_QUERY="INSERT INTO SPRING_CUSTOMER VALUES(CNO_SEQ1.NEXTVAL,?,?,?,?)";
	@Autowired
	private  JdbcTemplate jt;

	@Override
	public int insert(CustomerBO bo) throws Exception {
		System.out.println("OracleCustomerDAOImpl.insert(-):: "+jt.getDataSource().getClass());
	  int count=jt.update(CUSTOMER_INSERT_QUERY,
			                              bo.getCname(),bo.getCadd(),bo.getPamt(),bo.getIntramt());
	  return count;
  }
}
