package com.java.controller;

import com.java.model.User;
import com.java.service.api.UserServiceAPI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/api/v1")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserServiceAPI userServiceAPI;

    @GetMapping(value = "/all")
    public List<User> getAll() {
        return userServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{username}")
    public User find(@PathVariable String username) {
        return userServiceAPI.get(username);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        User obj = userServiceAPI.save(user);
        return new ResponseEntity<User>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable String username) {
        User user = userServiceAPI.get(username);
        if (user != null) {
            userServiceAPI.delete(username);
        } else {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
