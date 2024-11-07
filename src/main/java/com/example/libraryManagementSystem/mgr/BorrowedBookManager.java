package com.example.libraryManagementSystem.mgr;

import com.example.libraryManagementSystem.model.VBorrowedBooks;
import com.example.libraryManagementSystem.service.BorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BorrowedBookManager {

    @Autowired
    private BorrowedBookService borrowedBookService;

    public String borrowBook(Integer userId, Integer bookId) {
        return borrowedBookService.borrowBook(userId, bookId);
    }

    public String returnBook(Integer userId, Integer bookId) {
        return borrowedBookService.returnBook(userId, bookId);
    }

    public List<VBorrowedBooks> getBorrowedBooksByUser(Integer userId) {
        return borrowedBookService.getBorrowedBooksByUser(userId);
    }

    public VBorrowedBooks getBorrowedBookByUser(Integer userId, Integer bookId) {
        return borrowedBookService.getBorrowedBookByUser(userId, bookId);
    }

}
