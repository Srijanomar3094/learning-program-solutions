package com.cognizant.springdata.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.springdata.jpa.hibernate.HibernateEmployeeService;
import com.cognizant.springdata.jpa.model.Employee;
import com.cognizant.springdata.jpa.service.SpringDataJPAEmployeeService;

@SpringBootApplication
public class JPAComparisonApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JPAComparisonApplication.class, args);
		
		System.out.println("=== JPA, Hibernate and Spring Data JPA Comparison ===\n");
		
		testSpringDataJPA(context);
		
		System.out.println("\n" + "=".repeat(60) + "\n");
		
		testHibernate(context);
	}

	private static void testSpringDataJPA(ApplicationContext context) {
		System.out.println("1. SPRING DATA JPA APPROACH");
		System.out.println("   - Less boilerplate code");
		System.out.println("   - Automatic transaction management");
		System.out.println("   - Repository pattern\n");
		
		SpringDataJPAEmployeeService springDataService = context.getBean(SpringDataJPAEmployeeService.class);
		
		Employee emp1 = new Employee("John Doe", 50000.0, "IT");
		Employee savedEmp = springDataService.addEmployee(emp1);
		System.out.println("✓ Added employee: " + savedEmp);
		
		System.out.println("✓ All employees: " + springDataService.getAllEmployees());
		
		springDataService.updateEmployee(savedEmp.getId(), 55000.0);
		System.out.println("✓ Updated employee salary");
		
		Employee foundEmp = springDataService.getEmployeeById(savedEmp.getId());
		System.out.println("✓ Found employee: " + foundEmp);
	}

	private static void testHibernate(ApplicationContext context) {
		System.out.println("2. HIBERNATE APPROACH");
		System.out.println("   - Manual session management");
		System.out.println("   - Manual transaction management");
		System.out.println("   - More boilerplate code\n");
		
		HibernateEmployeeService hibernateService = context.getBean(HibernateEmployeeService.class);
		
		Employee emp2 = new Employee("Jane Smith", 60000.0, "HR");
		Integer empId = hibernateService.addEmployee(emp2);
		System.out.println("✓ Added employee with ID: " + empId);
		
		System.out.println("✓ All employees: " + hibernateService.listEmployees());
		
		hibernateService.updateEmployee(empId, 65000.0);
		System.out.println("✓ Updated employee salary");
		
		System.out.println("✓ Updated employees: " + hibernateService.listEmployees());
	}
} 