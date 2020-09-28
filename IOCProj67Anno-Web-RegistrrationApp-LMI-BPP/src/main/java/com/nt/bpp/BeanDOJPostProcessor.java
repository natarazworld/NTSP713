package com.nt.bpp;

import java.time.LocalDateTime;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nt.bo.BaseBean;

@Component
public class BeanDOJPostProcessor implements BeanPostProcessor {
	
	public BeanDOJPostProcessor() {
		System.out.println("BeanDOJPostProcessor:0-param constructor");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanDOJPostProcessor.postProcessBeforeInitialization(-,-)");
		if(bean instanceof BaseBean) {
			((BaseBean) bean).setDoj(LocalDateTime.now());  // Initializing doj property with   sys date and time
			System.out.println(bean);
		}
	   return bean;
	}//method

}//class
