package com.example.libraryManagementSystem.mgr;

import com.example.libraryManagementSystem.model.VBook;
import com.example.libraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookManager {

    @Autowired
    private BookService bookService;

    public VBook createBook(VBook vBook) {
        return bookService.createBook(vBook);
    }

    public VBook updateBook(VBook vBook) {
        return bookService.updateBook(vBook);
    }

    public String deleteBook(Integer bookId) {
        return bookService.deleteBook(bookId);
    }

    public VBook getBookById(Integer bookId) {
        return bookService.getBookById(bookId);
    }

    public List<VBook> getAllBook() {
        return bookService.getAllBook();
    }
}



