package com.cognizant.spring.core.service;

import com.cognizant.spring.core.repository.BookRepository;
import java.util.List;
import java.util.ArrayList;

public class BookService {
    private BookRepository bookRepository;
    
    // Constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // Getter for demonstration
    public BookRepository getBookRepository() {
        return bookRepository;
    }
    
    public void addBook(String title, String author) {
        bookRepository.saveBook(title + " by " + author);
    }
    
    public List<String> getAllBooks() {
        return bookRepository.getAllBooks();
    }
    
    public String getBookById(int id) {
        return bookRepository.getBookById(id);
    }
    
    public String addBook(String title) {
        return bookRepository.saveBook(title);
    }
    
    public String getLibraryStatistics() {
        return "Library has " + bookRepository.getAllBooks().size() + " books";
    }
    
    public int getTotalBooks() {
        return bookRepository.getAllBooks().size();
    }
} 