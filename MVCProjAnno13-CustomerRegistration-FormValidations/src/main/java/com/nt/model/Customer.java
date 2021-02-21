package com.nt.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Customer {
	//private int cno;  //auto generated
	private String cname;
	private  String cadd;
	private  Float billAmt;
	private  String vflag="no";

}
