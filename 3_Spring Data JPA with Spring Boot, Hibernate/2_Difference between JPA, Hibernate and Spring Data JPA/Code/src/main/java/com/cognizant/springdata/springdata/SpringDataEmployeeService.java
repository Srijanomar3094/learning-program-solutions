package com.cognizant.springdata.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpringDataEmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee createEmployee(String name, String department, Double salary) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);
        return employeeRepository.save(employee);
    }
    
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
    
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
    
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
    
    public List<Employee> getEmployeesBySalaryGreaterThan(Double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }
} 