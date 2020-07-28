package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.College;
import com.nt.beans.ContactsInfo;
import com.nt.beans.MarksInfo;
import com.nt.beans.UniversityInfo;

public class CollectionInjectionTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		MarksInfo info=null;
		College clg=null;
		ContactsInfo cinfo=null;
		UniversityInfo uinfo=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean
		info=factory.getBean("mi",MarksInfo.class);
		System.out.println(info);
		System.out.println("-------------------------------------------------");
		clg=factory.getBean("clg",College.class);
		System.out.println(clg);
		System.out.println("--------------------------------------------------");
		cinfo=factory.getBean("cInfo",ContactsInfo.class);
		System.out.println(cinfo);
		System.out.println("---------------------------------------------");
		uinfo=factory.getBean("uInfo",UniversityInfo.class);
		System.out.println(uinfo);

	}

}
