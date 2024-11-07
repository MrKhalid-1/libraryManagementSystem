package com.example.libraryManagementSystem.dao;

import com.example.libraryManagementSystem.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TUser, Integer> {
}
