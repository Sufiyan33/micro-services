package com.company.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.management.entity.Company;

@Repository
public interface CompanyRepositoy extends JpaRepository<Company, Long> {

}
