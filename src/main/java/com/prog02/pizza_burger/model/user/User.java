package com.prog02.pizza_burger.model.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User {
    private final String name;
    private final String username;
    private final String email;
    private final String hashedPassword;


    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashPassword(password);
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available.", e);
        }
    }

    public boolean checkPassword(String userPassword) {
        return hashPassword(userPassword).equals(hashedPassword);
    }

    public String getName() { return name; }

    public String getUsername() { return username; }

    public String getEmail() { return email; }
}
