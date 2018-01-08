package com.example.SpringBatchDoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages="com.example")
@EnableScheduling
public class SpringBatchDocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchDocApplication.class, args);
	}
}
