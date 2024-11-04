package com.example.libraryManagementSystem.entity;

import jakarta.persistence.*;

import java.util.Date;

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
    private Date borrowedAt;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "return_date")
    private String returnDate;

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

    public Date getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(Date borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
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
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
