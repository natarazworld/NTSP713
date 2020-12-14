package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AOPConfig {
	
	@Bean(name="ADTxService")
	public  UserTransactionImp   createADTx() {
		return new UserTransactionImp();
	}
	
	@Bean(name="ADTxMgmr")
	public  UserTransactionManager   createADTxMgmr() {
		return new UserTransactionManager();
	}
	
	@Bean(name="jtaTxMgmr")
	public JtaTransactionManager createJtaTxMgmr() {
		 JtaTransactionManager jtaTxMgmr=new JtaTransactionManager();
		 jtaTxMgmr.setUserTransaction(createADTx());
		 jtaTxMgmr.setTransactionManager(createADTxMgmr());
		 return jtaTxMgmr;
	}


}
