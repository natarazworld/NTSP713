package com.nt.manager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.bo.UserDetailsBO;
import com.nt.dao.IAuthenticationDAO;
import com.nt.dto.UserDetailsDTO;

@Component("authManager")
public class AuthenticationManager {
	private ThreadLocal<UserDetailsDTO> threadLocal=new ThreadLocal();
	@Autowired
	private IAuthenticationDAO  dao;
	
	
	public void   signIn(String username,String password) {
		//convert username,password into  UserDetails object
		  UserDetailsDTO  dto=new UserDetailsDTO();
		  dto.setUsername(username); dto.setPassword(password);
		  //keep in ThreadLocal object
		  threadLocal.set(dto);
	}
	
	public  void signOut() {
		threadLocal.remove();
	}
	
	public  boolean  validate() {
		//get current Thread UserDetailsDTO object from  ThreadLocal
		UserDetailsDTO dto=threadLocal.get();
		//convert dto  to bo
		UserDetailsBO bo=new UserDetailsBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		int count=dao.authenticate(bo);
		return  count==1?true:false;
	}

}//class
