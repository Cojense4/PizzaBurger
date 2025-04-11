package com.prog02.pizza_burger.controller;

import com.prog02.pizza_burger.dto.BurgerDTO;
import com.prog02.pizza_burger.model.burger.Burger;
import com.prog02.pizza_burger.service.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/burgers")
public class BurgerController {

    @Autowired
    private BurgerService burgerService;

    // POST endpoint to create a custom burger from JSON input
    @PostMapping
    public ResponseEntity<Burger> createBurger(@RequestBody BurgerDTO burgerDTO) {
        Burger createdBurger = burgerService.createBurger(burgerDTO);
        return ResponseEntity.ok(createdBurger);
    }
}