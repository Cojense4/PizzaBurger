package com.prog02.pizza_burger;

import com.prog02.pizza_burger.model.burger.BurgerTemplate;
import com.prog02.pizza_burger.model.pizza.PizzaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prog02.pizza_burger.model.pizza.Pizza;
import com.prog02.pizza_burger.model.burger.Burger;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PizzaBurgerController {

    // A sample endpoint that returns a basic menu of pizzas and burgers.
    @GetMapping("/menu")
    public Menu getMenu() {
        // Replace these with your actual business logic to get menu data.

        List<Pizza> pizzas = new ArrayList<>();
        for (PizzaTemplate pizzaTemplate : PizzaTemplate.values()) {
            pizzas.add(pizzaTemplate.toPizza());
        }
        List<Burger> burgers = new ArrayList<>();
        for (BurgerTemplate burgerTemplate : BurgerTemplate.values()) {
            burgers.add(burgerTemplate.toBurger());
        }
        return new Menu(pizzas, burgers);
    }

    // Inner class for the response model (consider using separate DTOs in a real app)
    public static class Menu {
        private List<Pizza> pizzas;
        private List<Burger> burgers;

        public Menu(List<Pizza> pizzas, List<Burger> burgers) {
            this.pizzas = pizzas;
            this.burgers = burgers;
        }

        public List<Pizza> getPizzas() {
            return pizzas;
        }

        public List<Burger> getBurgers() {
            return burgers;
        }
    }
}