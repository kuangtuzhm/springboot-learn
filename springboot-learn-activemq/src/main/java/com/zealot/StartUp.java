package com.zealot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class StartUp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartUp.class, args);
	}
}