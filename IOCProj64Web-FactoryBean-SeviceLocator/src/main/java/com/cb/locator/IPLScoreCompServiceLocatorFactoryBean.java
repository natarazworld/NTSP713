package com.cb.locator;

import org.springframework.beans.factory.FactoryBean;

import com.ipl.external.IIPLScoreComp;
import com.ipl.external.IPLScoreCompImpl;

public class IPLScoreCompServiceLocatorFactoryBean implements FactoryBean<IIPLScoreComp> {
    private IIPLScoreComp  extComp;
	public IPLScoreCompServiceLocatorFactoryBean() {
		 extComp=new IPLScoreCompImpl();
	}
	
	@Override
	public IIPLScoreComp getObject() throws Exception {
	    // Tehnically speaking here we need  to add  jndi lookup code to get External comp ref ..  from Jndi registry.. Since we have
		 // Extenal comp (IPLScoreComp) as an ordinary java class..  we are just going to return object for it..  with out any lookup operation..
		return extComp;
	}

	@Override
	public Class<?> getObjectType() {
		return IIPLScoreComp.class;
	}
	
	@Override
	public boolean isSingleton() {
		return true;   //defaul is also true
	}

}
