package com.prog02.pizza_burger.service;

import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.user.CartManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {

    @Autowired
    private CartManager cartManager;

    public void addItem(MenuItem item) {
        cartManager.addItem(item);
    }

    public ArrayList<MenuItem> getCartItems() {
        return cartManager.getCartItems();
    }

    public void clearCart() {
        cartManager.clearCart();
    }
}