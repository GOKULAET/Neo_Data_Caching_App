package com.neoproject.datacaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DatacachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatacachingApplication.class, args);
	}

}
