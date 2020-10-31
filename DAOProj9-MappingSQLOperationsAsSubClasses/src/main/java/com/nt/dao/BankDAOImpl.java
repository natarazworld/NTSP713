package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.bo.BankAccountBO;

@Repository
public class BankDAOImpl implements IBankDAO {
	private static final String  GET_BANK_ACCOUNTS_BY_SAL_RANGE="SELECT ACNO,HOLDERNAME,BALANCE,STATUS FROM BANK_ACCOUNT  WHERE BALANCE>=? AND BALANCE<=?";
	private static final String  GET_BANK_ACCOUNT_BY_ACNO="SELECT ACNO,HOLDERNAME,BALANCE,STATUS FROM BANK_ACCOUNT  WHERE ACNO=?";
	private static final String UPDATE_BONUS_BY_BALANCE="UPDATE BANK_ACCOUNT  SET BALANCE=BALANCE+? WHERE BALANCE<?";
	
	BankAccountSelectorBySalRange selector1;
	BankAccountSelectorByAcno  selector2;
	BankAccountUpdatorByBalance updator1;
	
	@Autowired
	public BankDAOImpl(DataSource ds) {
		System.out.println("BankDAOImpl: 0-param consrtuctor");
		 selector1=new BankAccountSelectorBySalRange(ds, GET_BANK_ACCOUNTS_BY_SAL_RANGE);
		 selector2=new BankAccountSelectorByAcno(ds, GET_BANK_ACCOUNT_BY_ACNO);
		 updator1=new BankAccountUpdatorByBalance(ds, UPDATE_BONUS_BY_BALANCE);
	}

	@Override
	public List<BankAccountBO> getBankAccountsByBalanceRange(float start, float end) {
		System.out.println("BankDAOImpl.getBankAccountsByBalanceRange(-,-)");
		List<BankAccountBO> listBO=selector1.execute(start,end);
		return listBO;
	}
	
	//inner cum class sub class for  SQL query1
	private static class  BankAccountSelectorBySalRange extends  MappingSqlQuery<BankAccountBO>{
		
		 public BankAccountSelectorBySalRange(DataSource ds, String query) {
			  super(ds,query); //gives DS, query  to super class
			 System.out.println("BankDAOImpl.BankAccountSelectorBySalRange.2-param constructor");
		        //register  query param(?) with jdbc type
		        super.declareParameter(new SqlParameter(Types.FLOAT));
		        super.declareParameter(new SqlParameter(Types.FLOAT));
		        //make super class compile query 
		          super.compile();
		}     

		@Override
		public BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("BankDAOImpl.BankAccountSelectorBySalRange.mapRow(-)");
		    //convert RS record into BO class object
			BankAccountBO bo=new BankAccountBO();
			bo.setAcno(rs.getLong(1));
			bo.setHolderName(rs.getString(2));
			bo.setBalance(rs.getFloat(3));
			bo.setStatus(rs.getString(4));
			return bo;
		}//mapRow(-,-)
		
	}//inner class
  //=============================================================================
	@Override
	public BankAccountBO getBankAccountByAcno(long acno) {
		BankAccountBO bo=selector2.findObject(acno);
		return bo;
	}
	
	//inner cum sub class2 for Query2
	private static  class BankAccountSelectorByAcno extends  MappingSqlQuery<BankAccountBO>{
		
		public BankAccountSelectorByAcno(DataSource ds,String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}

		@Override
		public BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("BankDAOImpl.BankAccountSelectorBySalRange.mapRow(-)");
		    //convert RS record into BO class object
			BankAccountBO bo=new BankAccountBO();
			bo.setAcno(rs.getLong(1));
			bo.setHolderName(rs.getString(2));
			bo.setBalance(rs.getFloat(3));
			bo.setStatus(rs.getString(4));
			return bo;
		}//mapRow(-,-)
		
	}//inner class2
	//=====================================================================================
	@Override
	public int updateBankAccountWithBonusByBalance(float bonus,float maxBalance) {
		int count=updator1.update(bonus,maxBalance);
		return count;
	}
	 
	//inner cum subclass for  query3
	private static  class  BankAccountUpdatorByBalance extends SqlUpdate{
		
		public BankAccountUpdatorByBalance(DataSource ds,String query) {
			super(ds,query); 
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.compile();
		}//consturctor
	}//inner class3

}//outer class
