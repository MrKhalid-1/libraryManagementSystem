package com.example.libraryManagementSystem.mgr;

import com.example.libraryManagementSystem.model.VUser;
import com.example.libraryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManager {
    @Autowired
    private UserService userService;

    public VUser createUser(VUser vUser) {
        return userService.createUser(vUser);
    }

    public VUser updateUser(VUser vUser) {
        return userService.updateUser(vUser);
    }

    public String deleteUser(Integer userId) {
        return userService.deleteUser(userId);
    }

    public VUser getUserById(Integer userId) {
        return userService.getUserById(userId);
    }

    public List<VUser> getAllUser() {
        return userService.getAllUser();
    }
}
