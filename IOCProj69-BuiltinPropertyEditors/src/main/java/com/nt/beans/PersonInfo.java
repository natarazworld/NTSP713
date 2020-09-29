package com.nt.beans;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class PersonInfo {
	private long adharNo;
	private String pname;
	private  String[] addresses;
	private  float  salary;
	private  File  photoPath;
	private Currency  countryCurrency;
	private   Date  dob;
	private  Class  javaClass;
	private  Class[] javaClasses;
	private   InputStream inputFile;
	private URL  fbUrl;
	private  Locale   currentLocale;
	private  TimeZone  timezone;
	private  Properties props;
	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setAddresses(String[] addresses) {
		this.addresses = addresses;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public void setPhotoPath(File photoPath) {
		this.photoPath = photoPath;
	}
	public void setCountryCurrency(Currency countryCurrency) {
		this.countryCurrency = countryCurrency;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setJavaClass(Class javaClass) {
		this.javaClass = javaClass;
	}
	public void setJavaClasses(Class[] javaClasses) {
		this.javaClasses = javaClasses;
	}
	public void setInputFile(InputStream inputFile) {
		this.inputFile = inputFile;
	}
	public void setFbUrl(URL fbUrl) {
		this.fbUrl = fbUrl;
	}
	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}
	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	
	
	@Override
	public String toString() {
		return "PersonInfo [adharNo=" + adharNo + ", pname=" + pname + ", addresses=" + Arrays.toString(addresses)
				+ ", salary=" + salary + ", photoPath=" + photoPath + ", countryCurrency=" + countryCurrency + ", dob="
				+ dob + ", javaClass=" + javaClass + ", javaClasses=" + Arrays.toString(javaClasses) + ", inputFile="
				+ inputFile + ", fbUrl=" + fbUrl + ", currentLocale=" + currentLocale
				+ ", timezone=" + timezone + ", props=" + props + "]";
	}
	
	
	

}
