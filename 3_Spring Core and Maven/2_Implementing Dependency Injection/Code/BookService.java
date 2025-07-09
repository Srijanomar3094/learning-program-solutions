package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;
    
    public BookService() {
        System.out.println("BookService: Default constructor called");
    }
    
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("BookService: setBookRepository() called - Dependency Injection");
        this.bookRepository = bookRepository;
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