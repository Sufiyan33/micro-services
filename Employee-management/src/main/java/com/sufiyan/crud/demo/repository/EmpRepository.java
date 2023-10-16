package com.sufiyan.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sufiyan.crud.demo.modal.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {

	Employee findByEmployeeId(long empId);
}
