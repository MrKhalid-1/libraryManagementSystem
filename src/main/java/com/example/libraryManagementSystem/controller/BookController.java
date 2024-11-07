package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.mgr.BookManager;
import com.example.libraryManagementSystem.model.VBook;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private static final Logger LOG = LoggerFactory.getLogger(com.example.libraryManagementSystem.controller.BookController.class);

    @Autowired
    private BookManager bookManager;

    @Tag(name = "Book")
    @Operation(summary = "Add new book")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<VBook> addBook(@RequestBody VBook vBook) {
        LOG.debug("==> addBook()");
        return ResponseEntity.ok(bookManager.createBook(vBook));
    }

    @Tag(name = "Book")
    @Operation(summary = "Update new book")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<VBook> updateBook(@RequestBody VBook vBook) {
        LOG.debug("==>  updateBook()");
        return ResponseEntity.ok(bookManager.updateBook(vBook));
    }

    @Tag(name = "Book")
    @Operation(summary = "Delete book by Id")
    @RequestMapping(method = RequestMethod.DELETE, path = "/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) {
        LOG.debug("==> deleteBook()");
        return ResponseEntity.ok(bookManager.deleteBook(bookId));
    }

    @Tag(name = "Book")
    @Operation(summary = "Book by Id")
    @RequestMapping(method = RequestMethod.GET, path = "/{bookId}")
    public ResponseEntity<VBook> getBookById(@PathVariable Integer bookId) {
        LOG.debug("==> addBook()");
        return ResponseEntity.ok(bookManager.getBookById(bookId));
    }

    @Tag(name = "Book")
    @Operation(summary = "All books")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VBook>> getAllBook() {
        LOG.debug("==> allBook()");
        return ResponseEntity.ok(bookManager.getAllBook());
    }
}

