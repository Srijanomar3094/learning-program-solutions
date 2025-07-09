package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private BookRepository bookRepository;
    
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public BookService() {
    }
    
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public String getBookById(int id) {
        return bookRepository.findBookById(id);
    }
    
    public String addBook(String bookTitle) {
        return bookRepository.saveBook(bookTitle);
    }
    
    public int getTotalBooks() {
        return bookRepository.getBookCount();
    }
    
    public String getLibraryStatistics() {
        int totalBooks = getTotalBooks();
        return "Library Statistics: Total Books = " + totalBooks;
    }
} 