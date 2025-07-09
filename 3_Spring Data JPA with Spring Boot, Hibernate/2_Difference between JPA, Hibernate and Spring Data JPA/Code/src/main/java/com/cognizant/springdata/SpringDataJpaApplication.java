package com.cognizant.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.springdata.jpa.JPAEmployeeService;
import com.cognizant.springdata.hibernate.HibernateEmployeeService;
import com.cognizant.springdata.springdata.SpringDataEmployeeService;

@SpringBootApplication
public class SpringDataJpaApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
        
        System.out.println("=== Spring Data JPA Comparison Demo ===");
        
        // Get all three service implementations
        JPAEmployeeService jpaService = context.getBean(JPAEmployeeService.class);
        HibernateEmployeeService hibernateService = context.getBean(HibernateEmployeeService.class);
        SpringDataEmployeeService springDataService = context.getBean(SpringDataEmployeeService.class);
        
        System.out.println("\n--- JPA Employee Service Demo ---");
        jpaService.createEmployee("John Doe", "Engineering", 75000.0);
        jpaService.createEmployee("Jane Smith", "Marketing", 65000.0);
        System.out.println("All employees (JPA): " + jpaService.getAllEmployees());
        
        System.out.println("\n--- Hibernate Employee Service Demo ---");
        hibernateService.createEmployee("Bob Johnson", "Sales", 70000.0);
        hibernateService.createEmployee("Alice Brown", "HR", 60000.0);
        System.out.println("All employees (Hibernate): " + hibernateService.getAllEmployees());
        
        System.out.println("\n--- Spring Data JPA Employee Service Demo ---");
        springDataService.createEmployee("Charlie Wilson", "IT", 80000.0);
        springDataService.createEmployee("Diana Davis", "Finance", 75000.0);
        System.out.println("All employees (Spring Data JPA): " + springDataService.getAllEmployees());
        
        System.out.println("\n--- Comparison Summary ---");
        System.out.println("JPA Service: " + jpaService.getClass().getSimpleName());
        System.out.println("Hibernate Service: " + hibernateService.getClass().getSimpleName());
        System.out.println("Spring Data JPA Service: " + springDataService.getClass().getSimpleName());
        
        System.out.println("\n=== Spring Data JPA Comparison Demo Complete ===");
    }
} 