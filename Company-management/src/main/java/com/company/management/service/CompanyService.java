package com.company.management.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.entity.Company;
import com.company.management.repository.CompanyRepositoy;
import org.springframework.web.client.RestTemplate;

@Service
public class CompanyService {

	private static final Logger log = LoggerFactory.getLogger(CompanyService.class.getSimpleName());

	@Autowired
	CompanyRepositoy repo;

	@Autowired
	private RestTemplate restTemplate;

	public Company save(Company company) {
		return repo.save(company);
	}

	public List<Company> saveAllDetails(List<Company> company) {
		return repo.saveAll(company);
	}

	public Company fetchCompany(long companyId) {

		return repo.findById(companyId).get();
	}

	public List<Company> fetchAllCompanyDetails() {
		return repo.findAll();
	}

	public Company updateCompanyDetails(Company companyObj, long companyId) {
		log.info("Company object is : " + companyObj);
		Company existingCompany = repo.findById(companyId)
				.orElseThrow(() -> new RuntimeException("Company not exist wiht id: " + companyId));

		existingCompany.setCompanyName(companyObj.getCompanyName());
		existingCompany.setCompanyAddress(companyObj.getCompanyAddress());
		existingCompany.setCompanyEmail(companyObj.getCompanyEmail());
		existingCompany.setCompanyCode(companyObj.getCompanyCode());
		repo.save(existingCompany);
		return existingCompany;
	}

	public Company updateCompany(long companyId, Company companyObj) {
		Company existingCompany = repo.findById(companyId)
				.orElseThrow(() -> new RuntimeException("Company not exist wiht companyId: "));
		existingCompany.setCompanyName(companyObj.getCompanyName());
		existingCompany.setCompanyEmail(companyObj.getCompanyEmail());
		existingCompany.setCompanyCode(companyObj.getCompanyCode());
		repo.save(existingCompany);
		return existingCompany;
	}

	public String deleteRecord(long id) {
		repo.deleteById(id);
		return "Company has been deleted : " + id;
	}

	/*
	 * public RespnseTemplateVO fetchEmployeeWithDepartment(long id) {
	 * RespnseTemplateVO vo = new RespnseTemplateVO(); Company comObj =
	 * repo.findByComId(id);
	 * 
	 * Employee companyObj =
	 * restTemplate.getForObject("http://localhost:8088/employee/com",
	 * Employee.class, comObj.getCompanyId()); vo.setCompany(comObj);
	 * vo.setEmployee(companyObj); return vo; }
	 */

	// This will be used to search employee with companyId
	public Company findCompanyById(Long companyId) {
		return repo.findByCompanyId(companyId);
	}

}
