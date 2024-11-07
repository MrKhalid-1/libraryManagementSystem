package com.example.libraryManagementSystem.entity;

import jakarta.persistence.*;
import com.example.libraryManagementSystem.common.AppContants;
import org.springframework.boot.autoconfigure.mail.MailProperties;

import java.util.Date;

@Entity
@Table(name = "users")
public class TUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name" , nullable = false , length = 30)
    private String name;

    @Column(name = "username", unique = true, nullable = false , length = 30)
    private String userName;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false , length = 30)
    private String email;

    @Column(name = "mobile", unique = true, nullable = false , length = 30)
    private String mobile;

    @Column(name = "role",nullable = false)
    @Enumerated(EnumType.STRING)
    private AppContants.UserRoles userRole;

    @Column(name = "created_at")
    private String createdDate;

    @Column(name = "updated_at")
    private Date updatedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public AppContants.UserRoles getUserRole() {
        return userRole;
    }

    public void setUserRole(AppContants.UserRoles userRole) {
        this.userRole = userRole;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userRole=" + userRole +
                ", createdDate='" + createdDate + '\'' +
                ", updatedDate=" + updatedDate +
                '}';
    }
}