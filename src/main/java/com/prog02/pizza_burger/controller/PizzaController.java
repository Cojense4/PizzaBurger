package com.prog02.pizza_burger.controller;

import com.prog02.pizza_burger.dto.PizzaDTO;
import com.prog02.pizza_burger.model.pizza.Pizza;
import com.prog02.pizza_burger.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<Pizza> createPizza(@RequestBody PizzaDTO pizzaDTO) {
        Pizza createdPizza = pizzaService.createPizza(pizzaDTO);
        return ResponseEntity.ok(createdPizza);
    }
}