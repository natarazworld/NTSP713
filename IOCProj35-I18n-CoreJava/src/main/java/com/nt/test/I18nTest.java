package com.nt.test;

import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {

	public static void main(String[] args) {
		Locale locale=null;
		ResourceBundle bundle=null;
		//prepare Local object having language and country
		locale=new Locale(args[0],args[1]);  //args[0] -language  , args[1]- country
		//Create ResourceBundle object having Locale object  (Collects the properties file info into bundle object based on given Locale obj data)
		
		bundle=ResourceBundle.getBundle("com/nt/commons/App",locale);
		//read and displays  values
		System.out.println(bundle.getString("btn1.cap")+"      "+bundle.getString("btn2.cap")+"    "+bundle.getString("btn3.cap")+"    "+bundle.getString("btn4.cap"));

	}

}
 //Before running this App  Change console  enconding UTF-8
  // windows--->preferences ---> general --> worksspace ---> textfile encoding-->other (radio button) :: select UTF8


