package com.example.demo.controller;

import com.example.demo.components.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestParam String email, @RequestParam String password) {
        return userService.registerUser(email, password);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = userService.authenticateUser(email, password);
        return "Welcome " + user.getEmail() + "!";
    }
}
