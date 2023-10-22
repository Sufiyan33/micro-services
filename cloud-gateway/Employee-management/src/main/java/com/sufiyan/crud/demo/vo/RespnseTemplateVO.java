package com.sufiyan.crud.demo.vo;

import com.sufiyan.crud.demo.modal.Employee;

public class RespnseTemplateVO {

	private Employee employee;
	private Company company;

	public RespnseTemplateVO() {
		super();
	}

	public RespnseTemplateVO(Employee employee, Company company) {
		super();
		this.employee = employee;
		this.company = company;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
