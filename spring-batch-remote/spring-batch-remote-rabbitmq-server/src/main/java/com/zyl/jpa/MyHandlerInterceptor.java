package com.zyl.jpa;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Data;

public class MyHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj)
			throws Exception {
		System.out.println("preHandle");
		httpservletresponse.getWriter().write("fdsfdsfds");
		//httpservletrequest.getRequestDispatcher("/WEB-INF/views/home1.jsp").forward(httpservletrequest, httpservletresponse);
		//httpservletresponse.sendRedirect("/WEB-INF/views/home1.jsp");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			ModelAndView modelandview) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
		//modelandview.setViewName("home1");
		httpservletrequest.getRequestDispatcher("/WEB-INF/views/home1.jsp").forward(httpservletrequest, httpservletresponse);
		//modelandview.addObject("serverTime", new Date().getTime());
		return;
	}

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			Exception exception) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("afterCompletion");
		
	}

}
