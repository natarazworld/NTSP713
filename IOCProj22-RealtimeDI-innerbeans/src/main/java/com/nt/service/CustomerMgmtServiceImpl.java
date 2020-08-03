package com.nt.service;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;

public final class CustomerMgmtServiceImpl implements CustomerMgmtService {
	private  CustomerDAO dao;

	public CustomerMgmtServiceImpl(CustomerDAO dao) {
		this.dao = dao;
	}

	@Override
	public String calculateIntrestAmount(CustomerDTO dto) throws Exception {
	    float intrAmt=0.0f;
	    CustomerBO bo=null;
	    int count=0;
		//calculate intrest amount
	    intrAmt=(dto.getPamt()*dto.getRate()*dto.getTime())/100.0f;
		//prepare CustomerBO object having persistable data...
	    bo=new CustomerBO();
	    bo.setCname(dto.getCname());
	    bo.setCadd(dto.getCadd());
	    bo.setPamt(dto.getPamt());
	    bo.setIntramt(intrAmt);
	    //use dAO
	    count=dao.insert(bo);
	    // process the result
	    if(count==0)
	    	  return "Customer Registration failed :: Amt::"+dto.getPamt()+"  intrest::"+intrAmt;
	    else 
	    	 return "Customer Registration Succeded :: Amt::"+dto.getPamt()+"  intrest::"+intrAmt;
	}
}
