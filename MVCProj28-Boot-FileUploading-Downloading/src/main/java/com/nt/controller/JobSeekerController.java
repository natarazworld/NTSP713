package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

@Controller
public class JobSeekerController {
	@Autowired
	private  IJobSeekerMgmtService service;
	@Autowired
	private  ServletContext sc;
	
	@GetMapping("/upload")
	public  String showForm(@ModelAttribute("jsForm") JobSeeker js) {
		js.setJsQlfy("engg");
		//return lvn;
		return  "jobseeker_form";
	}
	
	@PostMapping("/upload")
	public String uploadForm(Map<String,Object> map, 
			                    @ModelAttribute("jsForm") JobSeeker js)throws Exception{
		//create folder in server machine file System having uploaded location
		 File file=new File("E:/uploadStore");
		 if(!file.exists())
			  file.mkdir();
		 //get names of the upload files  from model object
		 String photoFileName=js.getPhoto().getOriginalFilename();
		 String  resumeFileName=js.getResume().getOriginalFilename();
		 //create Inputstreams reprsenting uploaded file
		 InputStream  photoIS=js.getPhoto().getInputStream();
		 InputStream resumeIS=js.getResume().getInputStream();
		 //create OutputStream pointing to dest files
		 OutputStream photoOS=new FileOutputStream(file.getAbsolutePath().replace('\\','/') +"/"  +photoFileName);
		 OutputStream resumeOS=new FileOutputStream(file.getAbsolutePath().replace('\\','/') +"/"+resumeFileName);
		 //Copy the content
		 IOUtils.copy(photoIS, photoOS);
		 IOUtils.copy(resumeIS,resumeOS);
		 //close streams
		 photoOS.close();
		 resumeOS.close();
		 photoIS.close();
		 resumeIS.close();
		 //send the names of uploaded to result page as model attrobutes
		 map.put("fileName1",photoFileName);
		 map.put("fileName2",resumeFileName);
		 // prepare Entity class object
		 JobSeekerInfo info=new JobSeekerInfo();
		 info.setJsName(js.getJsName());
		 info.setJsQlfy(js.getJsQlfy());
		 info.setPhotoPath(file.getAbsolutePath().replace('\\','/') +"/"  +photoFileName);
		 info.setResumePath(file.getAbsolutePath().replace('\\','/') +"/"  +resumeFileName);
		 //use service
		 String msg=service.registerJobSeeker(info);
		 //keep resuilt in model attributes
		 map.put("resultMsg",msg);
		 
		//return lvm
		return "result";
	}
	
	@GetMapping("/list_files")
	public    String  showFiles(Map<String,Object> map) {
		//use srerice
		List<JobSeekerInfo> list=service.getAllFiles();
		//add as model attribute
		map.put("filesList",list);
		return  "show_files";
	}
	
	@GetMapping("/download")
	public   String  downloadFile(@RequestParam("fname") String fileName,
			                                         HttpServletResponse res ) throws Exception{
		//Locate the file usin  java.io.File object
		File file=new File(fileName);
		//get the length of the file and make it as response content length
		res.setContentLengthLong((file.length()));
		//get MIME of the file make it response content type
		String mimeType=sc.getMimeType(fileName);
		res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
		// give instruction to browser to make the recieved content as the downloadable file
		res.addHeader("Content-Disposition","attachment;fileName="+file.getName());
		//create InputStream pointing to file
		InputStream is=new FileInputStream(file);
		//create OutputStream pointing to  response obj
		OutputStream os=res.getOutputStream();
		//complete file copy process
		IOUtils.copy(is,os);
		//since response going to browser directly from handler method itself.. So return null  (do not take void)
		return null;
	}

}
