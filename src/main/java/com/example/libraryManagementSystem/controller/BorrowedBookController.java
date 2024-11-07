package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.mgr.BorrowedBookManager;
import com.example.libraryManagementSystem.model.VBook;
import com.example.libraryManagementSystem.model.VBorrowedBooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowed")
public class BorrowedBookController {
    private static final Logger LOG = LoggerFactory.getLogger(com.example.libraryManagementSystem.controller.BorrowedBookController.class);

    @Autowired
    private BorrowedBookManager borrowedBookManager;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> borrowBook(@RequestParam Integer userId, @RequestParam Integer bookId) {
        LOG.debug("==> borrowedBook()");
        return ResponseEntity.ok(borrowedBookManager.borrowBook(userId, bookId));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/returnBook")
    public ResponseEntity<?> returnBook(@RequestParam Integer userId, @RequestParam Integer bookId) {
        LOG.debug("==> returnBook()");
        return ResponseEntity.ok(borrowedBookManager.returnBook(userId, bookId));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/books")
    public ResponseEntity<List<VBorrowedBooks>> getBorrowedBooksByUser(@RequestParam Integer userId) {
        LOG.debug("==> BorrowedBooksByUser()");
        return ResponseEntity.ok(borrowedBookManager.getBorrowedBooksByUser(userId));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/book")
    public ResponseEntity<VBorrowedBooks> getBorrowedBookByUser(@RequestParam Integer userId , @RequestParam Integer bookId) {
        LOG.debug("==> BorrowedBooksByUser()");
        return ResponseEntity.ok(borrowedBookManager.getBorrowedBookByUser(userId,bookId));
    }

/**
 * 3.3 Get Borrowed Books by User
 * public List<BorrowedBook> getBorrowedBooksByUser(Long userId) {
 *     return borrowedBooksRepository.findByUserIdAndReturnDateIsNull(userId);
 * }
 */
}


   /* @RequestMapping(method = RequestMethod.DELETE, path = "/{borrowedBookId}")
    public ResponseEntity<String> deleteBorrowedBook(@PathVariable Integer borrowedBookId) {
        LOG.debug("==> deleteBorrowedBook()");
        return ResponseEntity.ok(borrowedBookManager.deleteBorrowedBook(borrowedBookId));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{borrowedBookId}")
    public ResponseEntity<VBorrowedBook> getBorrowedBookById(@PathVariable Integer borrowedBookId) {
        LOG.debug("==> addBorrowedBook()");
        return ResponseEntity.ok(borrowedBookManager.getBorrowedBookById(borrowedBookId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VBorrowedBook>> getAllBorrowedBook() {
        LOG.debug("==> allBorrowedBook()");
        return ResponseEntity.ok(borrowedBookManager.getAllBorrowedBook());
    }
    */
