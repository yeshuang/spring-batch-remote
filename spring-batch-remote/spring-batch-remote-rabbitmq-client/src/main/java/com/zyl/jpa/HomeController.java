package com.zyl.jpa;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyl.jpa.ds.DataSourceHolder;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/a")
public class HomeController implements ApplicationContextAware{
	
	private  final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private  final Logger loggerZyl = LoggerFactory.getLogger(getClass());
	
	@Autowired
	HomeService homeService;
	
	@RequestMapping("a1")
	public String getStr(){
		loggerZyl.debug("测试{}{}", "1","2");
		return "home";
	}

	@RequestMapping("a2")
	@ResponseBody
	public String ZYLGomeTestRepository(){
		try {
			homeService.saveWithTran();
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
		
		return "success";
	}
	
	@RequestMapping("a3")
	public String aaaaa(@RequestParam("a") MydomainDto m,Map<String,Object> map,Map<String,Object> map2){
		try {
			map.put("aaa",m);
			map2.put("aaa","123");
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
		return "home";
	}
	
	@RequestMapping("a9")
	public String fsfdsf(){
		
		return "redirect:/a/a1.do";  
	}
	
	@RequestMapping("a10")
	public void a10(){
		homeService.read();
		 
	}
	
	@RequestMapping("a11")
	public void a11(){
		homeService.write();
		 
	}
	
	@RequestMapping("a66")
	@ResponseBody
	public String a66(HttpServletRequest request,HttpServletResponse respone){

		request.setAttribute("a","123");
		request.setAttribute("a","456");
		request.removeAttribute("a");
		
		return "success";
	}

	@RequestMapping("a666")
	@ResponseBody
	public String a666(HttpServletRequest request,HttpServletResponse respone){

		homeService.ZYLGomeRepository();
		
		return "success";
	}
	
	@RequestMapping("d")
	@ResponseBody
	public String d(HttpServletRequest request,HttpServletResponse respone) throws Exception{

		homeService.d();

		return "success";
	}
	
	@RequestMapping("d1")
	@ResponseBody
	public String d1(HttpServletRequest request,HttpServletResponse respone) throws Exception{

		homeService.d1();

		return "success";
	}
	
	 @InitBinder  
    public void dataBinder(WebDataBinder binder) {  
       binder.registerCustomEditor(MydomainDto.class , new Mydomain());  
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		for(String str:applicationContext.getBeanDefinitionNames()){
			System.out.println(str);
		}
		System.out.println(applicationContext.getBean("homeService"));
	}
	
	
	@RequestMapping("q999")
	@ResponseBody
	public String q999(HttpServletRequest request,HttpServletResponse respone) throws Exception{

		homeService.q999();

		return "success";
	}
	
	
}
