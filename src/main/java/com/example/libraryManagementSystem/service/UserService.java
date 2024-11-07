package com.example.libraryManagementSystem.service;

import com.example.libraryManagementSystem.dao.UserRepository;
import com.example.libraryManagementSystem.entity.TUser;
import com.example.libraryManagementSystem.model.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public VUser createUser(VUser vUser) {
        TUser tUser = convertToEntity(vUser);
        TUser savedUser = userRepository.save(tUser);
        return convertToView(savedUser);
    }

    public VUser updateUser(VUser vUser) {
        TUser tUser = convertToEntity(vUser);
        TUser updatedUser = userRepository.save(tUser);
        return convertToView(updatedUser);
    }

    public String deleteUser(Integer userId) {
        Optional<TUser> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            return "User Not Found!!";
        }

        userRepository.deleteById(userId);
        return "Deleted successfully";
    }


    public VUser getUserById(Integer userId) {
        Optional<TUser> tUserOptional = userRepository.findById(userId);
        if (tUserOptional.isPresent()) {
            TUser tUser = tUserOptional.get();
            return convertToView(tUser);
        } else {
            return null;
        }
    }

    public List<VUser> getAllUser() {
        List<TUser> list = userRepository.findAll();
        List<VUser> userList = new ArrayList<>();
        for (TUser tUser : list) {
            VUser vUser = convertToView(tUser);
            userList.add(vUser);
        }
        return userList;
    }


    private TUser convertToEntity(VUser vUser) {
        TUser tUser = new TUser();
        tUser.setId(vUser.getId());
        tUser.setName(vUser.getName());
        tUser.setUserName(vUser.getUserName());
        tUser.setPassword(vUser.getPassword());
        tUser.setEmail(vUser.getEmail());
        tUser.setMobile(vUser.getMobile());
        tUser.setUserRole(vUser.getUserRole());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        tUser.setCreatedDate(LocalDate.now().format(formatter));
        tUser.setUpdatedDate(vUser.getUpdatedDate());
        return tUser;
    }


    private VUser convertToView(TUser tUser) {
        VUser vUser = new VUser();
        vUser.setId(tUser.getId());
        vUser.setName(tUser.getName());
        vUser.setUserName(tUser.getUserName());
        vUser.setPassword(tUser.getPassword());
        vUser.setEmail(tUser.getEmail());
        vUser.setMobile(tUser.getMobile());
        vUser.setUserRole(tUser.getUserRole());
        vUser.setCreatedDate(tUser.getCreatedDate());
        vUser.setUpdatedDate(tUser.getUpdatedDate());
        return vUser;
    }
}
