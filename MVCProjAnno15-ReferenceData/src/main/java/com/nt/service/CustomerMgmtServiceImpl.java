package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ICustomerDAO;
import com.nt.model.Customer;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private ICustomerDAO dao;

	@Override
	public String register(Customer cust) {
		//use DAO
		int count=dao.insert(cust);
		return (count==0)?"Customer Registration Failed":"Customer Registration succeded";
	}

	@Override
	public Set<String> fetchAllCountries() {
		Locale locales[]=Locale.getAvailableLocales();
		Set<String> countriesSet=new HashSet();
		for(Locale l:locales) {
			countriesSet.add(l.getDisplayCountry());
		}
		
		return countriesSet;
	}

	@Override
	public Set<String> fetchAllLaguages() {
		Locale locales[]=Locale.getAvailableLocales();
		Set<String> languagesSet=new HashSet();
		for(Locale l:locales) {
			languagesSet.add(l.getDisplayLanguage());
		}
		return languagesSet;
	}

}
