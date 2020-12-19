package com.nt.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO  implements Serializable {
	private  Integer eno;
	@NonNull
	private  String ename;
	@NonNull
	private  String eadd;
	@NonNull
	private  Float eSalary;
	
	public  EmployeeDTO(int eno) {
		this.eno=eno;
	}
	
	
}
