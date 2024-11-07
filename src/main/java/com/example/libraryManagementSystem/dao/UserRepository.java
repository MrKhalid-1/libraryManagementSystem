package com.example.libraryManagementSystem.dao;

import com.example.libraryManagementSystem.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<TUser, Integer> {

    @Query("Select u from TUser u where u.userName = ?1")
    TUser findByUsername(String UserName);
}
