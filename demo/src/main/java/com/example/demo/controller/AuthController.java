package com.example.demo.controller;

import com.example.demo.components.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User registeredUser = userService.authenticateUser(user);
        return ResponseEntity.ok(registeredUser);
    }
}
