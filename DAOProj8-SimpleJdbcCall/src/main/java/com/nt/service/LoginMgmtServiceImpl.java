package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IAuthenticationDAO;

@Service("loginService")
public class LoginMgmtServiceImpl implements ILoginMgmtService {
	@Autowired
	private IAuthenticationDAO dao;

	@Override
	public String login(String user, String pwd) {
		//use dAO
		String  result=dao.authentication(user, pwd);
		return result;
	}

}
