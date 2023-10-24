package com.sufiyan.departmentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sufiyan.departmentservice.modal.Department;
import com.sufiyan.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repo;

	public void save(Department department) {
		repo.save(department);
	}

	public void saveAllDepartment(List<Department> department) {
		repo.saveAll(department);
	}

	public Department getDepartment(long departmentId) {
		return repo.findById(departmentId).get();
	}

	public List<Department> fetchAllDepartment() {

		return repo.findAll();
	}
}
