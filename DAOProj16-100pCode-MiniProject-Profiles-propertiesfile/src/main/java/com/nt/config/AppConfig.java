package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfig.class,ServiceConfig.class,ControllerConfig.class})
public class AppConfig {

}
