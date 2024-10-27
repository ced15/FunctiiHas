package com.example.demo;

import com.example.demo.components.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
@SpringBootApplication
public class HashFunctionApplication{

    public static void main(String[] args) {
        SpringApplication.run(HashFunctionApplication.class, args);
    }

}

