package com.sns.pjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BootSnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSnsApplication.class, args);
	}

} 
 