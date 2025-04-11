package com.prog02.pizza_burger.model.user;

import com.prog02.pizza_burger.model.common.MenuItem;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class CartManager {
    private static CartManager instance;
    private ArrayList<MenuItem> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
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
}