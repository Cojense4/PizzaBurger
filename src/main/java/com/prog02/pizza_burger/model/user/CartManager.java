package com.prog02.pizza_burger.model.user;

import com.prog02.pizza_burger.model.common.MenuItem;

import java.util.ArrayList;

public class CartManager {
    private static CartManager instance;
    private ArrayList<MenuItem> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addItem(MenuItem item) {
        cartItems.add(item);
    }

    public ArrayList<MenuItem> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }
    // Additional methods for managing the cart (remove, clear, etc.)
}