package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCConfig;

public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		//create Parent IOC container
		AnnotationConfigWebApplicationContext pCtx=new AnnotationConfigWebApplicationContext();
		pCtx.register(RootAppConfig.class);
		//create ContextLoaderListener having parent IOC container and register with ServletContainer using
		  // ServletContext object
		ContextLoaderListener listener=new ContextLoaderListener(pCtx);
		sc.addListener(listener);
		
		//create child IOC container
		AnnotationConfigWebApplicationContext cCtx=new AnnotationConfigWebApplicationContext();
		cCtx.register(WebMVCConfig.class);
		//Create DispatcherServlet having child IOC contaniner and  register that with ServletContainer using ServletContext obj..
		DispatcherServlet servlet=new DispatcherServlet(cCtx);
		ServletRegistration.Dynamic dyna=sc.addServlet("ds", servlet);
		dyna.addMapping("/");
		dyna.setLoadOnStartup(2);
	}

}
