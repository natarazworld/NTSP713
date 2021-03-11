package com.nt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.User;

public interface UserRepo extends CrudRepository<User, String> {
	
	@Query("SELECT count(*) FROM User WHERE username=:un AND password=:pwd")  //HQL/JPQL  
	public    int   authenticate(@Param("un")String username,@Param("pwd") String password);

}
