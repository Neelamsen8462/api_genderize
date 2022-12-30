package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringbootApplication {
	String baseURL = "http://localhost:8080/api/gender/api";


	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootApplication.class, args);
		
	}
}
