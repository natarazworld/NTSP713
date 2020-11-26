package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.UserDetailsBO;

public class AuthenticationDAOImpl implements IAuthenticationDAO {
	private  static final String AUTH_QUERY="SELECT COUNT(*) FROM  USERSLIST WHERE USERNAME=? AND PASSWORD=?";
	private JdbcTemplate jt;

	public AuthenticationDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int authenticate(UserDetailsBO bo) {
		int  count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUsername(),bo.getPassword());
		return count;
	}

}
