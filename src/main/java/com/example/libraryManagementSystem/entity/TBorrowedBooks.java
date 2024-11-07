package com.example.libraryManagementSystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrowed_books")
public class TBorrowedBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "borrowed_at")
    private LocalDate borrowedAt;

    @Column(name = "due_date")
    private LocalDate dueDate;

//    @Column(name = "due_amount")
//    private Integer dueAmount;

    @Column(name = "return_date")
    private LocalDate returnDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(LocalDate borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }


    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

//    public Integer getDueAmount() {
//        return dueAmount;
//    }
//
//    public void setDueAmount(Integer dueAmount) {
//        this.dueAmount = dueAmount;
//    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "TBorrowedBooks{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", borrowedAt=" + borrowedAt +
                ", dueDate=" + dueDate +
//                ", dueAmount=" + dueAmount +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
