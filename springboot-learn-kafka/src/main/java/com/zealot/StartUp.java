package com.zealot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.zealot")
@EnableScheduling
public class StartUp {

	public static void main(String[] args) {

		SpringApplication.run(StartUp.class, args);
	}
	
//	@Bean
//	public HealthIndicator getDubboHealthIndicator()
//	{
//		DubboHealthIndicator bean = new DubboHealthIndicator();
//		return bean;
//	}
}
