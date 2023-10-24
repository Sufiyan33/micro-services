/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.management.VO;

import com.company.management.entity.Company;

/**
 *
 * @author 91976
 */
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