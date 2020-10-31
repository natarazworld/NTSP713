package com.nt.bo;

import lombok.Data;

@Data
public class BankAccountBO {
	private Long acno;
	private String holderName;
	private  Float balance;
	private String status;  

}
