package com.sufiyan.crud.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient
public class CrudDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(CrudDemoApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
		log.info("This is the main class of spring boot");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
