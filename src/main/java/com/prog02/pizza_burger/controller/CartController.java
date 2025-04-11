package com.prog02.pizza_burger.controller;

import com.prog02.pizza_burger.dto.BurgerDTO;
import com.prog02.pizza_burger.model.burger.Burger;
import com.prog02.pizza_burger.service.BurgerService;
import com.prog02.pizza_burger.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private BurgerService burgerService;

    // Endpoint to add a burger to the cart
    @PostMapping("/add-burger")
    public ResponseEntity<Burger> addBurgerToCart(@RequestBody BurgerDTO burgerDTO) {
        // Create a Burger using the business logic in BurgerService.
        Burger burger = burgerService.createBurger(burgerDTO);
        cartService.addItem(burger);
        return ResponseEntity.ok(burger);
    }

    // Endpoint to retrieve all cart items
    @GetMapping
    public ResponseEntity<List<?>> getCartItems() {
        return ResponseEntity.ok(cartService.getCartItems());
    }

    // Endpoint to clear the cart
    @DeleteMapping
    public ResponseEntity<?> clearCart() {
        cartService.clearCart();
        return ResponseEntity.ok().build();
    }
}