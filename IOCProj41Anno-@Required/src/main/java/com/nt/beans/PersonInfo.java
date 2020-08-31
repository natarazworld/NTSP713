package com.nt.beans;

import org.springframework.beans.factory.annotation.Required;

public class PersonInfo {
     private int pid;
     private String pname;
     private  String paddrs;
     
	@Required
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	@Required
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPaddrs(String paddrs) {
		this.paddrs = paddrs;
	}

	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	
     
}
