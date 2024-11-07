package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.dao.BookRepository;
import com.example.libraryManagementSystem.entity.TBook;
import com.example.libraryManagementSystem.entity.TUser;
import com.example.libraryManagementSystem.model.VBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public VBook createBook(VBook vBook) {
        TBook tBook = convertToEntity(vBook);
        TBook savedBook = bookRepository.save(tBook);
        return convertToView(savedBook);
    }

    public VBook updateBook(VBook vBook) {
        TBook tBook = convertToEntity(vBook);
        TBook updatedBook = bookRepository.save(tBook);
        return convertToView(updatedBook);
    }


    public String deleteBook(Integer bookId) {
        Optional<TBook> book = bookRepository.findById(bookId);

        if (!book.isPresent()) {
            return "Book Not Found!!";
        }

        bookRepository.deleteById(bookId);
        return "Deleted successfully";
    }

    public VBook getBookById(Integer bookId) {
        Optional<TBook> tBookOptional = bookRepository.findById(bookId);
        if (tBookOptional.isPresent()) {
            TBook tBook = tBookOptional.get();
            return convertToView(tBook);
        } else {
            return null;
        }
    }

    public List<VBook> getAllBook() {
        List<TBook> list = bookRepository.findAll();
        List<VBook> bookList = new ArrayList<>();

        for (TBook tBook : list) {
            VBook vBook = convertToView(tBook);
            bookList.add(vBook);
        }

        return bookList;
    }

    private TBook convertToEntity(VBook vBook) {
        TBook tBook = new TBook();
        tBook.setId(vBook.getId());
        tBook.setTitle(vBook.getTitle());
        tBook.setAuthor(vBook.getAuthor());
        tBook.setIsbn(vBook.getIsbn());
        tBook.setPublishedDate(vBook.getPublishedDate());
        tBook.setAvailableQuantity(vBook.getAvailableQuantity());
        tBook.setTotalQuantity(vBook.getTotalQuantity());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        tBook.setCreatedDate(LocalDate.parse(LocalDate.now().format(formatter)));
        tBook.setUpdatedDate(vBook.getUpdatedDate(formatter));
        return tBook;
    }


    private VBook convertToView(TBook tBook) {
        VBook vBook = new VBook();
        vBook.setId(tBook.getId());
        vBook.setTitle(tBook.getTitle());
        vBook.setAuthor(tBook.getAuthor());
        vBook.setIsbn(tBook.getIsbn());
        vBook.setPublishedDate(tBook.getPublishedDate());
        vBook.setAvailableQuantity(tBook.getAvailableQuantity());
        vBook.setTotalQuantity(tBook.getTotalQuantity());
        vBook.setCreatedDate(LocalDate.parse(String.valueOf(tBook.getCreatedDate())));
        vBook.setUpdatedDate(tBook.getUpdatedDate());
        return vBook;
    }
}
    
