package com.cognizant.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.jpa.model.Employee;
import com.cognizant.jpa.repository.EmployeeRepository;

@Service
public class SpringDataJPAEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Transactional
	public Employee updateEmployee(Integer employeeId, Double salary) {
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		if (employee != null) {
			employee.setSalary(salary);
			return employeeRepository.save(employee);
		}
		return null;
	}

	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Transactional(readOnly = true)
	public Employee getEmployeeById(Integer employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}
} 