package com.cognizant.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.jpa.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

} 