package com.cognizant.spring.di;

public class BookRepository {
    
    public BookRepository() {
        System.out.println("BookRepository: Constructor called - Bean created");
    }
    
    public String findBookById(int id) {
        System.out.println("BookRepository: findBookById() called with ID: " + id);
        return "Book with ID " + id + " - Sample Title";
    }
    
    public String saveBook(String bookTitle) {
        System.out.println("BookRepository: saveBook() called with title: " + bookTitle);
        return "Book '" + bookTitle + "' saved successfully";
    }
    
    public int getBookCount() {
        System.out.println("BookRepository: getBookCount() called");
        return 100;
    }
} 