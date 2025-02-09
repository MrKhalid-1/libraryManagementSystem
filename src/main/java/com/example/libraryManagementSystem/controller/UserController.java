package com.example.libraryManagementSystem.controller;

import com.example.libraryManagementSystem.mgr.UserManager;
import com.example.libraryManagementSystem.model.VUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(com.example.libraryManagementSystem.controller.UserController.class);

    @Autowired
    private UserManager userManager;

    @RequestMapping(method = RequestMethod.GET , path ="/home")
    public HashMap<Object, String> home() {
        HashMap<Object, String> hashMap = new HashMap<>();
        LOG.debug("==> Home()");
        hashMap.put("home", "WelCome Home Khalid");
        return hashMap;
    }

    //    @Tag(name = "User")
//    @Operation(summary = "Add new company")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<VUser> addUser(@RequestBody VUser vUser) {
        LOG.debug("==> addUser()");
        return ResponseEntity.ok(userManager.createUser(vUser));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<VUser> updateUser(@RequestBody VUser vUser) {
        LOG.debug("==>  updateUser()");
        return ResponseEntity.ok(userManager.updateUser(vUser));
    }


    @RequestMapping(method = RequestMethod.DELETE , path = "/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        LOG.debug("==> deleteUser()");
        return ResponseEntity.ok(userManager.deleteUser(userId));
    }

    @RequestMapping(method = RequestMethod.GET , path = "/{userId}")
    public ResponseEntity<VUser> getUserById(@PathVariable Integer userId) {
        LOG.debug("==> addUser()");
        return ResponseEntity.ok(userManager.getUserById(userId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VUser>> getAllUser() {
        LOG.debug("==> allUser()");
        return ResponseEntity.ok(userManager. getAllUser());
    }
}
