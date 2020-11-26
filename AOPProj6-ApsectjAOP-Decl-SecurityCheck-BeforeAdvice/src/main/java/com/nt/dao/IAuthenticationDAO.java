package com.nt.dao;

import com.nt.bo.UserDetailsBO;

public interface IAuthenticationDAO {
    public  int   authenticate(UserDetailsBO bo);
}
