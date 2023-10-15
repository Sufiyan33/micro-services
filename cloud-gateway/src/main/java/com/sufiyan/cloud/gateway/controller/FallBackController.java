package com.sufiyan.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
	
	@GetMapping("/employeServiceFallback")
	public String employeServiceFallbackMethod() {
		return "Employee management service is taking longer time than expected." + "Please try again later";
	}
	
	@GetMapping("/companyServiceFallback")
	public String companyServiceFallbackMethod() {
		return "Company management service is taking longer time than expected." + "Please try again later";
	}

}
