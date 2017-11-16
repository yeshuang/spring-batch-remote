package com.zyl.jpa;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class dubboserver {

	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext clx = new ClassPathXmlApplicationContext("classpath:spring/dubbo-context.xml");
		clx.registerShutdownHook();
		Thread.sleep(1000000l);
	}
}
