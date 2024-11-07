package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.dao.BookRepository;
import com.example.libraryManagementSystem.dao.BorrowedBookRepository;
import com.example.libraryManagementSystem.entity.TBook;
import com.example.libraryManagementSystem.entity.TBorrowedBooks;
import com.example.libraryManagementSystem.model.VBorrowedBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BorrowedBookService {

    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @Autowired
    private BookRepository bookRepository;

    private static final int DAILY_CHARGE = 10;

    public String borrowBook(Integer userId, Integer bookId) {
        TBorrowedBooks tBorrowedBooks = new TBorrowedBooks();
        Optional<TBook> tBook = bookRepository.findById(bookId);
        tBorrowedBooks.setUserId(userId);
        tBorrowedBooks.setBookId(bookId);
        tBorrowedBooks.setBorrowedAt(LocalDate.now());
        tBorrowedBooks.setDueDate(LocalDate.now().plusDays(30));
        borrowedBookRepository.save(tBorrowedBooks);
        TBook tBook1 = tBook.get();
        tBook1.setAvailableQuantity(tBook1.getAvailableQuantity() - 1);
        bookRepository.save(tBook1);
        return "ok";
    }

    public String returnBook(Integer userId, Integer bookId) {
        TBorrowedBooks tBorrowedBooks = borrowedBookRepository.findTBorrowedBook(userId, bookId);
        tBorrowedBooks.setReturnDate(LocalDate.now());
        borrowedBookRepository.save(tBorrowedBooks);
        Optional<TBook> tBook = bookRepository.findById(bookId);
        TBook tBook1 = tBook.get();
        tBook1.setAvailableQuantity(tBook1.getAvailableQuantity() + 1);
        bookRepository.save(tBook1);
        return "return";
    }

    public List<VBorrowedBooks> getBorrowedBooksByUser(Integer userId) {
        List<TBorrowedBooks> tBorrowedBooksList = borrowedBookRepository.findTBorrowedBooks(userId);
        if (tBorrowedBooksList.isEmpty()) {
            throw new RuntimeException("No borrowed books found for the user!");
        }
        List<VBorrowedBooks> vBorrowedBooksList = new ArrayList<>();
        for (TBorrowedBooks tBorrowedBook : tBorrowedBooksList) {
            vBorrowedBooksList.add(convertToView(tBorrowedBook));
        }
        return vBorrowedBooksList;
    }


    public VBorrowedBooks getBorrowedBookByUser(Integer userId, Integer bookId) {
        TBorrowedBooks tBorrowedBooks = borrowedBookRepository.findTBorrowedBook(userId, bookId);
        if (tBorrowedBooks == null) {
            throw new RuntimeException("Book Not Found!");
        }
        VBorrowedBooks vBorrowedBooks = convertToView(tBorrowedBooks);
        return vBorrowedBooks;
    }

    private TBorrowedBooks convertToEntity(VBorrowedBooks vBorrowedBooks) {
        TBorrowedBooks tBorrowedBooks = new TBorrowedBooks();
        tBorrowedBooks.setId(vBorrowedBooks.getId());
        tBorrowedBooks.setUserId(vBorrowedBooks.getUserId());
        tBorrowedBooks.setBookId(vBorrowedBooks.getBookId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        tBorrowedBooks.setBorrowedAt(LocalDate.parse(LocalDate.now().format(formatter)));
        tBorrowedBooks.setDueDate(LocalDate.parse(vBorrowedBooks.getDueDate().format(formatter)));
//        tBorrowedBooks.setDueAmount(vBorrowedBooks.getDueAmount());
        tBorrowedBooks.setReturnDate(LocalDate.parse(vBorrowedBooks.getReturnDate().format(formatter)));
        return tBorrowedBooks;
    }


    private VBorrowedBooks convertToView(TBorrowedBooks tBorrowedBooks) {
        VBorrowedBooks vBorrowedBooks = new VBorrowedBooks();
        vBorrowedBooks.setId(tBorrowedBooks.getId());
        vBorrowedBooks.setUserId(tBorrowedBooks.getUserId());
        vBorrowedBooks.setBookId(tBorrowedBooks.getBookId());
        vBorrowedBooks.setBorrowedAt(tBorrowedBooks.getBorrowedAt());
        vBorrowedBooks.setDueDate(tBorrowedBooks.getDueDate());
//        vBorrowedBooks.setDueAmount(calculateOverdueCharge(tBorrowedBooks.getDueDate(), tBorrowedBooks.getReturnDate()));
        vBorrowedBooks.setDueAmount(calculateOverdueCharge(tBorrowedBooks.getDueDate(), LocalDate.now()));
        vBorrowedBooks.setReturnDate(tBorrowedBooks.getReturnDate());
        return vBorrowedBooks;
    }

    public static int calculateOverdueCharge(LocalDate dueDate, LocalDate returnDate) {
        if (returnDate.isAfter(dueDate)) {
            long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
            return (int) overdueDays * DAILY_CHARGE;
        } else {
            return 0;
        }
    }
}
