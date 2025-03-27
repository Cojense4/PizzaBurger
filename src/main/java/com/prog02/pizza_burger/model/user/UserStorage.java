package com.prog02.pizza_burger.model.user;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private static Map<String, User> users = new HashMap<>();
    private static User currentUser;

    public static void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public static User authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        return null;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
