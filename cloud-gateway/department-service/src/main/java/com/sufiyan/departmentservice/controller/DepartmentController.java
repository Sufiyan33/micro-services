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

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@PostMapping("/save")
	public void saveDepartment(@RequestBody Department department) {
		service.save(department);
	}

	@PostMapping("/saveAll")
	public void saveAllDepartment(@RequestBody List<Department> department) {
		service.saveAllDepartment(department);
	}

	@GetMapping("/{id}")
	public Department fetchDepartment(@PathVariable("id") Long departmentId) {
		return service.getDepartment(departmentId);
	}

	@GetMapping("/fetchAll")
	public List<Department> getAllDepartment() {
		return service.fetchAllDepartment();
	}

	@GetMapping("/hello")
	public String getString() {
		return "Hello Just for testing";
	}

}
