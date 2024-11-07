package com.example.libraryManagementSystem.dao;

import com.example.libraryManagementSystem.entity.TBorrowedBooks;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BorrowedBookRepository extends JpaRepository<TBorrowedBooks , Integer> {

    @Query("SELECT b from TBorrowedBooks b where b.userId = ?1 and b.bookId =?2")
    TBorrowedBooks findTBorrowedBook(Integer userId , Integer bookId);

    @Query("SELECT b from TBorrowedBooks b where b.userId = ?1")
    List<TBorrowedBooks> findTBorrowedBooks(Integer userId);

}
