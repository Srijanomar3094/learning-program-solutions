package com.cognizant.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        System.out.println("=== Spring Dependency Injection Demo ===");
        
        // Load Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("di-config.xml");
        
        System.out.println("\n--- Constructor Injection Demo ---");
        BookService constructorInjectedService = context.getBean("constructorInjectedService", BookService.class);
        constructorInjectedService.displayBookInfo();
        
        System.out.println("\n--- Setter Injection Demo ---");
        BookService setterInjectedService = context.getBean("setterInjectedService", BookService.class);
        setterInjectedService.displayBookInfo();
        
        System.out.println("\n--- Field Injection Demo ---");
        BookService fieldInjectedService = context.getBean("fieldInjectedService", BookService.class);
        fieldInjectedService.displayBookInfo();
        
        System.out.println("\n--- Demonstrating Different Injection Types ---");
        System.out.println("Constructor Injection Repository: " + constructorInjectedService.getBookRepository());
        System.out.println("Setter Injection Repository: " + setterInjectedService.getBookRepository());
        System.out.println("Field Injection Repository: " + fieldInjectedService.getBookRepository());
        
        System.out.println("=== Spring Dependency Injection Demo Complete ===");
    }
} 