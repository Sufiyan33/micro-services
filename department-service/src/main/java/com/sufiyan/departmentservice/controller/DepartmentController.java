package com.sufiyan.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sufiyan.departmentservice.modal.Department;
import com.sufiyan.departmentservice.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/department")
@Tag(name = "Department Controller", description = "Created department controller")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@PostMapping("/save")
	@Operation(description = "Save Department Data", summary = "We are trying to save department data one by one into H2 Database.", responses = {
			@ApiResponse(description = "Success", responseCode = "201", content = { @Content(mediaType = "JSON") }),
			@ApiResponse(description = "UnAuthorized", ref = "", responseCode = "403") }, method = "Post", deprecated = false, parameters = {
					@Parameter(name = "Department", description = "For this postMapping only this Department param is enough") })
	public void saveDepartment(@RequestBody Department department) {
		service.save(department);
	}

	@PostMapping("/saveAll")
	@Operation(description = "Save all Department Data", summary = "We are trying to save all department into H2 Database.", responses = {
			@ApiResponse(description = "Success", responseCode = "201", content = { @Content(mediaType = "JSON") }),
			@ApiResponse(description = "UnAuthorized", ref = "", responseCode = "403") }, method = "Post", deprecated = false, parameters = {
					@Parameter(name = "List of Department", description = "For this postMapping only this Department param is enough") })
	public void saveAllDepartment(@RequestBody List<Department> department) {
		service.saveAllDepartment(department);
	}

	@GetMapping("/{id}")
	@Operation(description = "Fetch Department", summary = "We are trying to fetch department data based on id from H2 Database.", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "JSON") }),
			@ApiResponse(description = "UnAuthorized", ref = "", responseCode = "403") }, method = "Get", deprecated = false, parameters = {
					@Parameter(name = "departmentId", description = "Only departmentId is required here") })
	public Department fetchDepartment(@PathVariable("id") Long departmentId) {
		return service.getDepartment(departmentId);
	}

	@GetMapping("/fetchAll")
	@Operation(description = "Fetch all Department Data", summary = "We are trying to fetch all department data from H2 Database.", responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "JSON") }),
			@ApiResponse(description = "UnAuthorized", ref = "", responseCode = "403") }, method = "Get", deprecated = false)
	public List<Department> getAllDepartment() {
		return service.fetchAllDepartment();
	}

	@GetMapping("/hello")
	public String getString() {
		return "Hello Just for testing";
	}

}
