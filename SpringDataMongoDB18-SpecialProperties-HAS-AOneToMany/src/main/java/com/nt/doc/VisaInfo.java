package com.nt.doc;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisaInfo {
	private Long visaNo;
	private  String country;
	private  LocalDate expiryDate;

}
