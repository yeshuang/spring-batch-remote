package com.zyl.jpa;

import java.util.UUID;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext clx = new ClassPathXmlApplicationContext("classpath:spring/root-context.xml");
		
		JobLauncher launcher = (JobLauncher) clx.getBean("jobLauncher");
        Job job = (Job) clx.getBean("gomeJob");
		
        try {
            /* 运行Job */
            JobExecution result = launcher.run(job,new JobParametersBuilder()
            //.addLong("data",new Date().getTime())
            .addString("contr_nbr", "GMXD%")
            .addString("dealer_id", "N")
            //.addString("uuid",UUID.randomUUID().toString())
            .toJobParameters());
            /* 处理结束，控制台打印处理结果 */
            System.out.println(result.toString());
            clx.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
