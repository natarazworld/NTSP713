package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserDetailsBO;

@Repository("authDAO")
public class AuthenticationDAOImpl implements IAuthenticationDAO {
	private  static final String AUTH_QUERY="SELECT COUNT(*) FROM  USERSLIST WHERE USERNAME=? AND PASSWORD=?";
	@Autowired
	private JdbcTemplate jt;

	
	@Override
	public int authenticate(UserDetailsBO bo) {
		int  count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUsername(),bo.getPassword());
		return count;
	}

}
