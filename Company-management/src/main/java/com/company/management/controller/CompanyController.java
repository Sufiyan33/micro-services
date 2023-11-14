package com.company.management.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Company Management", description = "We are creating CURD apps with Spring Boot & taking Company as a reference")
public class CompanyController {

	private static final Logger log = LoggerFactory.getLogger(CompanyController.class.getSimpleName());

	@Autowired
	private CompanyService service;

	// http://localhost:8081/company/save

	@Operation(description = "Save Company Data", summary = "We are trying to save Company data one by one into H2 Database.", responses = {
			@ApiResponse(description = "Success", responseCode = "200"),
			@ApiResponse(description = "UnAuthorized", responseCode = "403") }, method = "Post", deprecated = false, parameters = {
					@Parameter(name = "Company") })
	@PostMapping("/save")
	public Company saveCompany(@RequestBody Company company) {
		log.info("Saving Company data");
		return service.save(company);
	}

	@Operation(description = "SaveAll Company Data", summary = "We are trying to save all Company data one by one into H2 Database.", responses = {
			@ApiResponse(description = "Success", responseCode = "200"),
			@ApiResponse(description = "UnAuthorized", responseCode = "403") }, method = "Post", deprecated = false, parameters = {
					@Parameter(name = "Company") })
	@PostMapping("/saveAll")
	public List<Company> saveAllCompany(@RequestBody List<Company> company) {
		return service.saveAllDetails(company);
	}

	@Operation(description = "Fetch Company by id", summary = "We will make call to h2 db with empId to fetch data record", method = "Get", parameters = {
			@Parameter(name = "id") }, responses = { @ApiResponse(description = "Success", responseCode = "200"),
					@ApiResponse(description = "InternalServer", responseCode = "500") }, operationId = "/com/{id}")
	// http://localhost:8081/company/com/{id}
	@GetMapping("/com/{id}")
	public Company getCompany(@PathVariable("id") long companyId) {
		log.info("Inside getCompany method :: ");
		return service.fetchCompany(companyId);
	}

	// This will be used to search employee with companyId
	@GetMapping("/{id}")
	public Company getCompanyById(@PathVariable("id") Long companyId) {
		log.info("Inside getCompanyById method when employee send restRequest :: ");
		return service.findCompanyById(companyId);
	}

	@Operation(description = "Fetch Company all by id", summary = "We will make call to h2 db with to fetch all data record", method = "Get", parameters = {
			@Parameter(name = "Not Required") }, responses = {
					@ApiResponse(description = "Success", responseCode = "200"),
					@ApiResponse(description = "InternalServer", responseCode = "500") }, operationId = "/allCompany")
	@GetMapping("/allCompany")
	public List<Company> getAllCompaniesDetails() {
		return service.fetchAllCompanyDetails();
	}

	@PutMapping("/put/{id}")
	@Operation(description = "Update comapny record", summary = "Put method will update if record already present if not then it will create record", method = "Put", parameters = {
			@Parameter(name = "id"), @Parameter(name = "employee") }, responses = {
					@ApiResponse(description = "On update", responseCode = "200"),
					@ApiResponse(description = "On create", responseCode = "201"),
					@ApiResponse(description = "InternalServer", responseCode = "500") })
	public Company updateCompany(@PathVariable("id") long companyId, @RequestBody Company company) {
		log.info("Company name: " + company.getCompanyName() + " company Id: " + company.getCompanyId() + " companyId: "
				+ companyId + " & company object is : " + company);
		return service.updateCompanyDetails(company, companyId);
	}

	@PatchMapping("patch/{id}")
	@Operation(description = "Update comapany record partially", summary = "Patch method will update existing data record partially", method = "Patch", parameters = {
			@Parameter(name = "id"), @Parameter(name = "employee") }, responses = {
					@ApiResponse(description = "On update", responseCode = "200"),
					@ApiResponse(description = "InternalServer", responseCode = "500") })
	public Company updatePartially(@PathVariable("id") long companyId, @RequestBody Company company) {
		return service.updateCompany(companyId, company);
	}

	@DeleteMapping("/delete/{companyId}")
	@Operation(description = "Delete data record", summary = "Delete existing data record by companyId", method = "Delete", parameters = {
			@Parameter(name = "id") }, responses = { @ApiResponse(description = "On Delete", responseCode = "200"),
					@ApiResponse(description = "Not Found", responseCode = "400") })
	public String deleteCompanyById(@PathVariable long companyId) {
		return service.deleteRecord(companyId);
	}

	/*
	 * @GetMapping("/fetch/{id}") public RespnseTemplateVO
	 * getEmployeeWithCompany(@PathVariable("id") long comId) { return
	 * service.fetchEmployeeWithDepartment(comId); }
	 */

}
