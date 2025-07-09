package com.cognizant.spring.core.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<String> books = new ArrayList<>();
    private int nextId = 1;
    
    public String saveBook(String bookTitle) {
        String bookInfo = "Book ID: " + nextId + ", Title: " + bookTitle;
        books.add(bookInfo);
        nextId++;
        return "Book saved: " + bookInfo;
    }
    
    public String getBookById(int id) {
        if (id > 0 && id <= books.size()) {
            return books.get(id - 1);
        }
        return "Book not found with ID: " + id;
    }
    
    public List<String> getAllBooks() {
        return new ArrayList<>(books);
    }
    
    public int getBookCount() {
        return books.size();
    }
} 