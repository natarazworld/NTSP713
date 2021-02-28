package com.nt.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Customer {
	//private int cno;  //auto generated
	private String cname;
	private  String cadd;
	private  Float billAmt;
	private  String vflag="no";
	private  String  gender="female";
	private  String[] hobies=new String[] {"Reading Books","Playing Games"};
	private  String country="India";
	private  List<String> langs=List.of("Hindi","Telugu");

}
