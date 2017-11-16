package com.zyl.jpa;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcException;
import com.zyl.jpa.dubbo.ServiceInterface;


public class DubboRpc implements Runnable{

	public static long curr =0;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext clx = new ClassPathXmlApplicationContext("classpath:spring/dubbo-context.xml");

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);  
		
		ServiceInterface serviceInterface = (ServiceInterface) clx.getBean("demoService");
		
		curr=System.currentTimeMillis();

		CyclicBarrier cyclicBarrier= new CyclicBarrier(1000, new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println(System.currentTimeMillis()-curr);
				} catch (RpcException e) {
					System.out.println("超时");
					e.printStackTrace();
				}
				
			}
		});
		
		for (int i = 0; i < 100; i++) {
			fixedThreadPool.execute(new Thread(new DubboRpc(serviceInterface,i,null)));
		}
		fixedThreadPool.shutdown();
		clx.registerShutdownHook();

	}
	public DubboRpc(ServiceInterface serviceInterface,int i){
		this.serviceInterface = serviceInterface;
		this.i = i;
	}
	
	public DubboRpc(ServiceInterface serviceInterface,int i,CyclicBarrier c){
		this.serviceInterface = serviceInterface;
		this.i = i;
		this.c=c;
	}
	
	public ServiceInterface serviceInterface;
	public int i ;
	public CyclicBarrier c;
	
	@Override
	public void run() {
		
		try {
			System.out.println(serviceInterface.getDubboRPC(String.valueOf(i)));
		} catch (RpcException e) {
			System.out.println("超时");
			e.printStackTrace();
		}
	}
}
