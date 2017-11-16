package com.zyl.jpa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyl.jpa.rpc.RPCservice;


public class RabbitMqRpc implements Runnable{

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		ClassPathXmlApplicationContext clx = new ClassPathXmlApplicationContext("classpath:spring/root-context.xml");

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);  
		
		RPCservice c = (RPCservice) clx.getBean("RPCSendToServer");
		for (int i = 0; i < 1000; i++) {
			fixedThreadPool.execute(new Thread(new RabbitMqRpc(c,i)));
		}
		fixedThreadPool.shutdown();
		clx.registerShutdownHook();
	}
	public RabbitMqRpc(RPCservice rPCservice,int i){
		this.rPCservice = rPCservice;
		this.i = i;
	}
	
	public RPCservice rPCservice;
	public int i ;
	
	@Override
	public void run() {
		System.out.println(rPCservice.getRPC(String.valueOf(i)).equals("respone" + String.valueOf(i)));
	}
}
