package com.cognizant.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.spring.core.service.BookService;
import com.cognizant.spring.core.repository.BookRepository;

public class SpringCoreDemo {
    public static void main(String[] args) {
        // Load Spring context from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("=== Spring Core Demo ===");
        
        // Get beans from Spring container
        BookService bookService = context.getBean("bookService", BookService.class);
        BookRepository bookRepository = context.getBean("bookRepository", BookRepository.class);
        
        // Demonstrate Spring Core functionality
        System.out.println("Book Service: " + bookService);
        System.out.println("Book Repository: " + bookRepository);
        
        // Show that Spring manages the beans
        System.out.println("Book Service Repository: " + bookService.getBookRepository());
        System.out.println("Are they the same instance? " + (bookService.getBookRepository() == bookRepository));
        
        // Demonstrate basic functionality
        bookService.addBook("Spring in Action", "Craig Walls");
        bookService.addBook("Effective Java", "Joshua Bloch");
        
        System.out.println("All books: " + bookService.getAllBooks());
        
        System.out.println("=== Spring Core Demo Complete ===");
    }
} 