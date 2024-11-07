package com.example.libraryManagementSystem.mgr;

import com.example.libraryManagementSystem.model.VBorrowedBooks;
import com.example.libraryManagementSystem.service.BorrowedBookService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public VBorrowedBooks getBorrowedBookByUser(Integer userId , Integer bookId) {
        return borrowedBookService.getBorrowedBookByUser(userId,bookId);
    }

}
/**
 * 3.3 Get Borrowed Books by User
 * public List<BorrowedBook> getBorrowedBooksByUser(Long userId) {
 *     return borrowedBooksRepository.findByUserIdAndReturnDateIsNull(userId);
 * }
 */