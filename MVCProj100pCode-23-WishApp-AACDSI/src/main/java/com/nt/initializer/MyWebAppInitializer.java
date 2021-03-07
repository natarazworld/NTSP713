package com.nt.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCConfig;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class };   // To specify  Configuration class of parent IOC container
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMVCConfig.class };  // To specify  Configuration class of child IOC container
	}

	@Override
	public String[] getServletMappings() {
		return new String[] {"/"};   //provides the url pattern
	}

}
