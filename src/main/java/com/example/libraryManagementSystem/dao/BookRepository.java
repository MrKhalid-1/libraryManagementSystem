package com.example.libraryManagementSystem.dao;

import com.example.libraryManagementSystem.entity.TBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<TBook, Integer> {
}
