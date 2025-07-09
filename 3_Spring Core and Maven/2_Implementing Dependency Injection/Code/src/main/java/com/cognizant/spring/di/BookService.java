package com.cognizant.spring.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BookService {
    private BookRepository bookRepository;
    
    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor injection used");
    }
    
    // Default constructor for setter injection
    public BookService() {
        System.out.println("BookService: Default constructor called");
    }
    
    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Setter injection used");
    }
    
    // Field Injection (using @Autowired)
    @Autowired
    public void injectBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Field injection used");
    }
    
    public BookRepository getBookRepository() {
        return bookRepository;
    }
    
    public void displayBookInfo() {
        if (bookRepository != null) {
            System.out.println("Book Service is using: " + bookRepository.getClass().getSimpleName());
            System.out.println("Repository instance: " + bookRepository);
        } else {
            System.out.println("Book Repository is null!");
        }
    }
    
    public String getBookById(int id) {
        System.out.println("BookService: getBookById() called with ID: " + id);
        return bookRepository.findBookById(id);
    }
    
    public String addBook(String bookTitle) {
        System.out.println("BookService: addBook() called with title: " + bookTitle);
        return bookRepository.saveBook(bookTitle);
    }
    
    public int getTotalBooks() {
        System.out.println("BookService: getTotalBooks() called");
        return bookRepository.getBookCount();
    }
    
    public String testDependencyInjection() {
        if (bookRepository != null) {
            return "Dependency Injection successful! BookRepository is properly injected.";
        } else {
            return "Dependency Injection failed! BookRepository is null.";
        }
    }
} 