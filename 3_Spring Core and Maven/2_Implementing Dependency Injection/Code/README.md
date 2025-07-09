# Exercise 2: Implementing Dependency Injection

## Purpose
This exercise demonstrates different types of dependency injection in Spring:
- Constructor Injection
- Setter Injection  
- Field Injection (using @Autowired)

## Files
- `BookService.java` - Service class demonstrating different injection types
- `BookRepository.java` - Repository class to be injected
- `LibraryManagementApplication.java` - Main application class

## How to Run

### Original Location
```bash
cd "3_Spring Core and Maven/2_Implementing Dependency Injection/Code"
mvn exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"
```

### New Location (Recommended)
```bash
cd ../../parent-project/exercise3-spring-dependency-injection
mvn exec:java -Dexec.mainClass="com.cognizant.spring.di.DependencyInjectionDemo"
```

## What You'll Learn
- Different ways to inject dependencies in Spring
- When to use each injection type
- How Spring manages object creation and wiring
- Best practices for dependency injection

## Key Concepts
- **Constructor Injection**: Dependencies provided through constructor parameters
- **Setter Injection**: Dependencies provided through setter methods
- **Field Injection**: Dependencies injected directly into fields using @Autowired
- **Bean Wiring**: How Spring connects dependent objects together 