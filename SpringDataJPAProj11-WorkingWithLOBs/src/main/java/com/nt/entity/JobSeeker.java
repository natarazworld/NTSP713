package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class JobSeeker {
	@Id
	@GeneratedValue
	private  Integer jsId;
	@Column(length=20)
	private String jsName;
	@Column(length=20)
	private  String qlfy;
	@Lob
	private  byte[]  photo;
	@Lob
	private  char[]  resume;
	private  boolean  status;

}
