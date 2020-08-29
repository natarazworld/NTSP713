package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.CustomerBO;

public final class MysqlCustomerDAOImpl implements CustomerDAO {
	private  static final  String   CUSTOMER_INSERT_QUERY="INSERT INTO SPRING_CUSTOMER(CNAME,CADD,PAMT,INTRAMT) VALUES(?,?,?,?)";
	private  DataSource ds;

	 //for constructor injection  (alt+shift+s,o)
		public MysqlCustomerDAOImpl(DataSource ds) {
			System.out.println("MysqlCustomerDAOImpl:: 0-param constructor");
		this.ds = ds;
	}

	@Override
	public int insert(CustomerBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get pooled jdbc connection
		con=ds.getConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(CUSTOMER_INSERT_QUERY);
		//set values to query params
		ps.setString(1,bo.getCname());
		ps.setString(2,bo.getCadd());
		ps.setFloat(3,bo.getPamt());
		ps.setFloat(4,bo.getIntramt());
		//execute the SQL query
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

}
