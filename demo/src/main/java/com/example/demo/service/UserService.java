package com.example.demo.service;

import com.example.demo.components.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setEmail(user.getEmail());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    public User authenticateUser(User user) {
        User retrievedUser = userRepository.findByEmail(user.getEmail()).orElseThrow(() -> new RuntimeException("Email is not registered"));

        if (!passwordEncoder.matches(user.getPassword(), retrievedUser.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        return retrievedUser;
    }
}
