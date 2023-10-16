package com.company.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.management.entity.Company;
import com.company.management.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private static final Logger log = LoggerFactory.getLogger(CompanyController.class.getSimpleName());
	
	@Autowired
	CompanyService service;
	
	@PostMapping("/save")
	public Company saveCompany(@RequestBody Company company) {
		log.info("Saving Company data");
		return service.save(company);
	}

	@PostMapping("/saveAll")
	public List<Company> saveAllCompany(@RequestBody List<Company> company) {
		return service.saveAllDetails(company);
	}

	@GetMapping("/com/{id}")
	public Company getCompany(@PathVariable("id") long companyId) {
		log.info("Inside getCompany method :: ");
		return service.fetchCompany(companyId);
	}
	
	//This will be used to search employee with companyId
	@GetMapping("/{id}")
	public Company getCompanyById(@PathVariable("id") Long companyId) {
		log.info("Inside getCompanyById method when employee send restRequest :: ");
			return service.findCompanyById(companyId);
	}

	@GetMapping("/allCompany")
	public List<Company> getAllCompaniesDetails() {
		return service.fetchAllCompanyDetails();
	}

	@PutMapping("/put/{id}")
	public Company updateCompany(@PathVariable("id") long companyId, @RequestBody Company company) {
		log.info("Company name: " + company.getCompanyName() + " company Id: " + company.getCompanyId() + " companyId: " + companyId
				+ " & company object is : " + company);
		return service.updateCompanyDetails(company, companyId);
	}

	@PatchMapping("patch/{id}")
	public Company updatePartially(@PathVariable("id") long companyId, @RequestBody Company company) {
		return service.updateCompany(companyId, company);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCompanyById(@PathVariable long companyId) {
		return service.deleteRecord(companyId);
	}
}
