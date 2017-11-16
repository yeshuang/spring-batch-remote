/*package com.zyl.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

*//**
 * Handles requests for the application home page.
 *//*
@Controller
@RequestMapping(value = "/batch")
public class BatchController {
	
	private static final Logger logger = LoggerFactory.getLogger(BatchController.class);

	@Autowired
	JobLauncher JobLauncher;
	
	@Autowired
	@Qualifier("gomeJob")
	Job job;
	
	@RequestMapping("a")
	@ResponseBody
	public String getStr(){
		
		JobExecution result = null;
		try {
			result = JobLauncher.run(job,new JobParametersBuilder()
			//.addLong("data",new Date().getTime())
			.addString("contr_nbr", "GMXD%")
			.addString("dealer_id", "N")
			.toJobParameters());
			System.out.println(result.toString());
		} catch (Exception e) {
			logger.error("error");
			return "fail";
		}
         处理结束，控制台打印处理结果   
		return "success";
	}
}
*/