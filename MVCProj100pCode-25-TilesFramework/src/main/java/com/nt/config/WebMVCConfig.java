package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@ComponentScan(basePackages = "com.nt.controller")
@EnableWebMvc
public class WebMVCConfig {

	
	@Bean
	public   TilesConfigurer   createTilesConfigurer() {
		TilesConfigurer  configurer=new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/tiles.xml");
		return configurer;
		
	}
	
	
	@Bean
	public TilesViewResolver createTilesViewResolver() {
		return new TilesViewResolver();
	}
	
}
