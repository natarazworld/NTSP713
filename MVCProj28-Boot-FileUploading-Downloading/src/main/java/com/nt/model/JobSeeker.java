package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobSeeker {
	private String jsName;
	private  String jsQlfy;
	private MultipartFile photo;
	private MultipartFile resume;

}
