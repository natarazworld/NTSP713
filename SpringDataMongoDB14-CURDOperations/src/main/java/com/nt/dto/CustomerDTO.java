//CustomerDTO.java
package com.nt.dto;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {
	    private String id;
		private Integer cno;
		private String cname;
		private  Float billAmt;
		private  String cadd;

}
