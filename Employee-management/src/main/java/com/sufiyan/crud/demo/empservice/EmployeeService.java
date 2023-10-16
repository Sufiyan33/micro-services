package com.sufiyan.crud.demo.empservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sufiyan.crud.demo.modal.Employee;
import com.sufiyan.crud.demo.repository.EmpRepository;
import com.sufiyan.crud.demo.vo.Company;
import com.sufiyan.crud.demo.vo.RespnseTemplateVO;

@Service
public class EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class.getSimpleName());

	@Autowired
	EmpRepository repo;

	@Autowired
	private RestTemplate restTemplate;

	public Employee save(Employee emp) {
		return repo.save(emp);
	}

	public List<Employee> saveAllDetails(List<Employee> emp) {
		return repo.saveAll(emp);
	}

	public Employee fetchEmployee(long empId) {
		return repo.findById(empId).get();
	}

	public List<Employee> fetchAllEmployeeDetails() {
		return repo.findAll();
	}

	public Employee updateDetails(Employee emp, long empId) {
		log.info("emp object is : " + emp);
		Employee existingEmployee = repo.findById(empId)
				.orElseThrow(() -> new RuntimeException("Employee not exist wiht id: " + empId));

		existingEmployee.setFirstName(emp.getFirstName());
		existingEmployee.setLastName(emp.getLastName());
		existingEmployee.setEmail(emp.getEmail());
		existingEmployee.setDepartment("CSE");
		existingEmployee.setBelongsTo("Team 1");
		repo.save(existingEmployee);
		return existingEmployee;
	}

	public Employee updateEmployee(long empId, Employee emp) {
		Employee existingEmp = repo.findById(empId)
				.orElseThrow(() -> new RuntimeException("Employee not exist wiht id: "));
		existingEmp.setEmail(emp.getEmail());
		existingEmp.setDepartment("IT");
		existingEmp.setBelongsTo("Team 2");
		repo.save(existingEmp);
		return existingEmp;
	}

	public String deleteRecord(long id) {
		repo.deleteById(id);
		return "Employee has been deleted : " + id;
	}

	public RespnseTemplateVO fetchEmployeeWithDepartment(long empId) {
		RespnseTemplateVO vo = new RespnseTemplateVO();
		Employee employeeObj = repo.findByEmployeeId(empId);

		Company companyObj = restTemplate.getForObject("http://localhost:8081/company", Company.class,
				employeeObj.getCompanyId());
		vo.setEmployee(employeeObj);
		vo.setCompany(companyObj);
		return vo;
	}
}
