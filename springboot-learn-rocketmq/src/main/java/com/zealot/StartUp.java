package com.zealot;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.zealot.learn.rocketmq.Consumer;
import com.zealot.learn.rocketmq.Producer;

@SpringBootApplication
@ComponentScan(basePackages = "com.zealot")
@EnableScheduling
public class StartUp implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(StartUp.class.getName());
	
	@Resource
	private Consumer consumer;
	
	@Resource
	private Producer producer;

	public static void main(String[] args) {

		SpringApplication.run(StartUp.class, args);
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("生产者开始启动：");
		producer.start();
		logger.info("生产者启动完成：");
		
		logger.info("消费者开始启动：");
        consumer.start();;
        logger.info("消费者启动完成：");
	}
}
