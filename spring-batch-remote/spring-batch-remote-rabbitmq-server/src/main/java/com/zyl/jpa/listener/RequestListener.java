package com.zyl.jpa.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;


public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener{

	@Override
	public void attributeAdded(
			ServletRequestAttributeEvent servletrequestattributeevent) {
		System.out.println("request添加属性" + servletrequestattributeevent.getName() + ":" +servletrequestattributeevent.getValue());
		
	}

	@Override
	public void attributeRemoved(
			ServletRequestAttributeEvent servletrequestattributeevent) {
		System.out.println("request删除属性" + servletrequestattributeevent.getName() + ":" +servletrequestattributeevent.getValue());
		
	}

	@Override
	public void attributeReplaced(
			ServletRequestAttributeEvent servletrequestattributeevent) {
		System.out.println("request替换属性" + servletrequestattributeevent.getName() + ":" +servletrequestattributeevent.getValue());
		System.out.println(servletrequestattributeevent.getServletRequest().getAttribute(servletrequestattributeevent.getName()));
	}

	@Override
	public void requestDestroyed(ServletRequestEvent servletrequestevent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent servletrequestevent) {
		// TODO Auto-generated method stub
		
	}

}
