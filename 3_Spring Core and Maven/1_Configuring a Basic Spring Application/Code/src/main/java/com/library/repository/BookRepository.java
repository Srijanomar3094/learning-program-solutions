package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    
    public String findBookById(int id) {
        return "Book with ID " + id + " - Sample Title";
    }
    
    public String saveBook(String bookTitle) {
        return "Book '" + bookTitle + "' saved successfully";
    }
    
    public int getBookCount() {
        return 100;
    }
} 