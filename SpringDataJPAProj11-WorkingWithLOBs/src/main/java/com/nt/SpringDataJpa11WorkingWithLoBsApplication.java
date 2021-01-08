package com.nt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.JobSeekerDTO;
import com.nt.service.IJobSeekerMgmtService;

@SpringBootApplication
public class SpringDataJpa11WorkingWithLoBsApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringDataJpa11WorkingWithLoBsApplication.class, args);
		//get Service class object
		IJobSeekerMgmtService  service=ctx.getBean("jsService",IJobSeekerMgmtService.class);
	
	
		/*//read inputs from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter jobSeeker name");
		String name=sc.next();
		System.out.println("Enter jobSeeker qlfy");
		String qlfy=sc.next();
		System.out.println("Enter jobSeeker PhotoLocation");
		String photoLocation=sc.next();
		System.out.println("Enter jobSeeker resumeLocation");
		String resumeLocation=sc.next();
		try {
		//create byte[]  representing  BLOB file (photo file)
		InputStream is=new FileInputStream(photoLocation);
		byte[] photoContent=new byte[is.available()];
		is.read(photoContent);
		
		//create byte[]  representing  CLOB file (photo file)
		File file=new File(resumeLocation);
		Reader reader=new FileReader(file);
		char[]  resumeContent=new char[(int)file.length()];
		reader.read(resumeContent);
		
		//create dTO class obj
		JobSeekerDTO dto=new JobSeekerDTO();
		dto.setJsName(name); dto.setQlfy(qlfy);
		dto.setPhoto(photoContent); dto.setResume(resumeContent); dto.setStatus(true);
		//invoke service class method
		  //System.out.println(service.registerJobSeeker(dto));
	}//try
	catch(DataAccessException dae) {
		dae.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}*/
		try {
		  System.out.println("---------------------------------------");
		  JobSeekerDTO dto1=service.getJobSeekerInfoById(48);
		  if(dto1!=null) {
		  System.out.println(dto1.getJsId()+"  "+dto1.getJsName()+"  "+dto1.getQlfy());
		   OutputStream os=new FileOutputStream("new_photo.jpg");
		   os.write(dto1.getPhoto());
		   Writer writer =new FileWriter("new_resume.txt");
		   writer.write(dto1.getResume());
		   os.flush();
		   writer.flush();
		   os.close();
		   writer.close();
		  }
		  else {
			  System.out.println("record not found");
		  }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		  
		//close container
			((ConfigurableApplicationContext) ctx).close();
		
		
	}//main
}//class
