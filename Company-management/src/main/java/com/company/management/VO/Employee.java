/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.management.VO;

/**
 *
 * @author 91976
 */
public class Employee {

	private long empId;
	private String firstName;
	private String lastName;
	private String email;
	private String department;
	private String belongsTo;
	private long companyId;

	public Employee(long empId, String firstName, String lastName, String email, String department, String belongsTo,
			long companyId) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
		this.belongsTo = belongsTo;
		this.companyId = companyId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBelongsTo() {
		return belongsTo;
	}

	public void setBelongsTo(String belongsTo) {
		this.belongsTo = belongsTo;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

}
