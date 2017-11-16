package com.zyl.jpa.dubbo;

public class ServiceImpl implements ServiceInterface{

	@Override
	public String getDubboRPC(String a) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "dubbo" + a;
	}
}
