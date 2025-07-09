package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    
    public static void main(String[] args) {
        System.out.println("=== Library Management Application - Dependency Injection Test ===");
        System.out.println("Loading Spring Application Context...");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Spring Context loaded successfully!");
        
        BookService bookService = context.getBean("bookService", BookService.class);
        
        System.out.println("\n--- Testing Dependency Injection ---");
        String diTest = bookService.testDependencyInjection();
        System.out.println("DI Test Result: " + diTest);
        
        System.out.println("\n--- Testing Library Operations ---");
        
        String bookInfo = bookService.getBookById(1);
        System.out.println("Book Info: " + bookInfo);
        
        String addResult = bookService.addBook("The Great Gatsby");
        System.out.println("Add Book Result: " + addResult);
        
        int totalBooks = bookService.getTotalBooks();
        System.out.println("Total Books in Library: " + totalBooks);
        
        System.out.println("\n=== Dependency Injection Test Completed Successfully ===");
        System.out.println("✓ BookRepository was successfully injected into BookService");
        System.out.println("✓ All operations are working through dependency injection");
        
        ((ClassPathXmlApplicationContext) context).close();
    }
} 