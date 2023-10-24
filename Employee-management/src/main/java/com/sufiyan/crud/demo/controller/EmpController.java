package com.sufiyan.crud.demo.controller;

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

import com.sufiyan.crud.demo.empservice.EmployeeService;
import com.sufiyan.crud.demo.modal.Employee;
import com.sufiyan.crud.demo.vo.RespnseTemplateVO;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employee")
@Tag(name = "Employee Management", description = "We are creating CURD apps with Spring Boot & taking Employee as a reference")
public class EmpController {

	private static final Logger log = LoggerFactory.getLogger(EmpController.class.getSimpleName());

	@Autowired
	private EmployeeService empService;

	//http://localhost:8081/employee/save
	@Hidden()
	@PostMapping("/save")
	@Operation(description = "Save Employee Data", summary = "We are trying to save employee data one by one into H2 Database.", responses = {
			@ApiResponse(description = "Success", responseCode = "201", content = { @Content(mediaType = "JSON") }),
			@ApiResponse(description = "UnAuthorized", ref = "", responseCode = "403") }, method = "Post", deprecated = false, parameters = {
					@Parameter(name = "Employee", description = "For this postMapping only this employee param is enough") })
	public Employee saveEmployee(@RequestBody Employee employee) {
		log.info("Saving employee data");
		return empService.save(employee);
	}

	@PostMapping("/saveAll")
	@Hidden
	@Operation(description = "Save all employeec data", summary = "Save employee bulk data or as a list into H2 Database", method = "Post", parameters = {
			@Parameter(name = "Not required!!!") }, responses = {
					@ApiResponse(description = "Success", responseCode = "201"),
					@ApiResponse(description = "UnAuthorized", responseCode = "403") }, deprecated = false)
	public List<Employee> saveAllEmployee(@RequestBody List<Employee> employees) {
		return empService.saveAllDetails(employees);
	}

	@GetMapping("/emp/{id}")
	@Operation(description = "Fetch employee by id", summary = "We will make call to h2 db with empId to fetch data record", method = "Get", parameters = {
			@Parameter(name = "id") }, responses = { @ApiResponse(description = "Success", responseCode = "200"),
					@ApiResponse(description = "InternalServer", responseCode = "500") })
	public Employee getEmployee(@PathVariable("id") long empId) {
		return empService.fetchEmployee(empId);
	}

	@GetMapping("/allEmp")
	@Operation(description = "Fetch employee", summary = "We will make call to h2 db to fetch all employee data record", method = "Get", parameters = {
			@Parameter(name = "Not required") }, responses = {
					@ApiResponse(description = "Success", responseCode = "200"),
					@ApiResponse(description = "InternalServer", responseCode = "500") })
	public List<Employee> getAllEmployeeDetails() {
		return empService.fetchAllEmployeeDetails();
	}

	@PutMapping("/update/{id}")
	@Operation(description = "Update employee record", summary = "Put method will update if record already present if not then it will create record", method = "Put", parameters = {
			@Parameter(name = "id"), @Parameter(name = "employee") }, responses = {
					@ApiResponse(description = "On update", responseCode = "200"),
					@ApiResponse(description = "On create", responseCode = "201"),
					@ApiResponse(description = "InternalServer", responseCode = "500") })
	public Employee updateEmployee(@PathVariable("id") long empId, @RequestBody Employee emp) {
		log.info("Emp name: " + emp.getFirstName() + " Emp Id: " + emp.getEmpId() + " empId: " + empId
				+ " & emp object is : " + emp);
		return empService.updateDetails(emp, empId);
	}

	@PatchMapping("updates/{id}")
	@Operation(description = "Update employee record partially", summary = "Patch method will update existing data record partially", method = "Patch", parameters = {
			@Parameter(name = "id"), @Parameter(name = "employee") }, responses = {
					@ApiResponse(description = "On update", responseCode = "200"),
					@ApiResponse(description = "InternalServer", responseCode = "500") })
	public Employee updatePartially(@PathVariable("id") long empId, @RequestBody Employee emp) {
		return empService.updateEmployee(empId, emp);
	}

	@DeleteMapping("/delete/{id}")
	@Operation(description = "Delete data record", summary = "Delete existing data record by empId", method = "Delete", parameters = {
			@Parameter(name = "id") }, responses = { @ApiResponse(description = "On Delete", responseCode = "200"),
					@ApiResponse(description = "Not Found", responseCode = "400") })
	public String deleteProductById(@PathVariable long id) {
		return empService.deleteRecord(id);
	}

	//http://localhost:8081/fetch/{id}

	// This will be used to search employee with companyId

	@GetMapping("/fetch/{id}")
	public RespnseTemplateVO getEmployeeWithCompany(@PathVariable("id") Long empId) {
		log.info("Inside getEmployeeWithCompany method ::");
		return empService.fetchEmployeeWithDepartment(empId);
	}
}
