package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class MvcProj28BootFileUploadingDownloadingApplication {

	 @Bean(name="multipartResolver")
	public   CommonsMultipartResolver  createCMResolver() {
		CommonsMultipartResolver  resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSizePerFile(20*1024);
		return resolver;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MvcProj28BootFileUploadingDownloadingApplication.class, args);
	}

}
