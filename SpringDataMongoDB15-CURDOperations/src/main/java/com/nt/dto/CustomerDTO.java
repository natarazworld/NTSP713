//CustomerDTO.java
package com.nt.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CustomerDTO implements Serializable {
	  @NonNull
		private Integer cno;
		private String cname;
		private  Float billAmt;
		private  String cadd;

}
