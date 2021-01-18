package com.nt.service;

import java.util.List;

public interface ICompanyMgmtService {
    public  List<Object[]>  fetchJoinsDataParentToChild();
    public  List<Object[]>  fetchJoinsDataChildToParent(); 
 
}
