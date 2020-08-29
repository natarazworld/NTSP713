package com.nt.listener;

import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class IOCContainerMonitoringListener implements ApplicationListener {
     private long start,end;
     
     public IOCContainerMonitoringListener() {
		System.out.println("Listener:: 0-param constructor");
	}
     
	@Override
	public void onApplicationEvent(ApplicationEvent e) {
		if(e.toString().indexOf("ContextRefreshed")!=-1) {
			start=System.currentTimeMillis();
			System.out.println("IOC contaier is started at::"+new Date());
		}
		else if(e.toString().indexOf("ContextClosed")!=-1) {
			end=System.currentTimeMillis();
			System.out.println("IOC contaier is stopped/closed at::"+new Date());
			System.out.println("IOC container active duration ::"+(end-start)+" ms");
		}

	}

}
