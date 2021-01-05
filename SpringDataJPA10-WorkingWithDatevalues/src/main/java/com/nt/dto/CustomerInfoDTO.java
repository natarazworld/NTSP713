//CustomerDTO.java
package com.nt.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class CustomerInfoDTO implements Serializable {
	private Integer custId;
	private  String  custName;
	private  Float  billAmt;
	private  LocalDate  dob;
	private  LocalTime  tob;
	private LocalDateTime billDate;
	
	

}
