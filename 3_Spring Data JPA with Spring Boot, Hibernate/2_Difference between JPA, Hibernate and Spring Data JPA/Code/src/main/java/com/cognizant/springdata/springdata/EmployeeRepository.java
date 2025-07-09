package com.cognizant.springdata.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    List<Employee> findByDepartment(String department);
    
    List<Employee> findBySalaryGreaterThan(Double salary);
    
    List<Employee> findByNameContaining(String name);
} 