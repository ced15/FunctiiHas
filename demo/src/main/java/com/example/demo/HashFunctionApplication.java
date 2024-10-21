package com.example.demo;

import com.example.demo.components.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
@SpringBootApplication
public class HashFunctionApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(HashFunctionApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the terminal authentication system.");
        System.out.println("Choose an option: ");
        System.out.println("1. Register");
        System.out.println("2. Login");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consumăm newline-ul rămas după nextInt()

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        try {
            if (choice == 1) {
                // Înregistrare
                User user = userService.registerUser(email, password);
                System.out.println("User registered successfully with email: " + user.getEmail());
            } else if (choice == 2) {
                // Autentificare
                User user = userService.authenticateUser(email, password);
                System.out.println("Welcome back, " + user.getEmail() + "!");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}

