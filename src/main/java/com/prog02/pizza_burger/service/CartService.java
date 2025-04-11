package com.prog02.pizza_burger.service;

import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.order.CartItem;
import com.prog02.pizza_burger.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem addCartItem(String itemType, String itemName, double price, String details) {
        CartItem cartItem = new CartItem(itemType, itemName, price, details);
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    // New overloaded method to accept a MenuItem
    public CartItem addCartItem(MenuItem menuItem) {
        String itemType = menuItem.getClass().getSimpleName();
        String itemName = menuItem.getName();
        double price = menuItem.getPrice();
        // You can adjust the details extraction as needed
        String details = menuItem.display();
        CartItem cartItem = new CartItem(itemType, itemName, price, details);
        return cartItemRepository.save(cartItem);
    }

    public void clearCart() {
        cartItemRepository.clearCart();
    }
}