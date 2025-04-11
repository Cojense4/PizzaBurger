package com.prog02.pizza_burger.service;

import com.prog02.pizza_burger.dto.PizzaDTO;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.pizza.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class PizzaService {

    public Pizza createPizza(PizzaDTO pizzaDTO) {
        Crust crust = MenuItem.fromItemName(Crust.class, pizzaDTO.getItemName());

        // Process sauces
        ArrayList<Sauce> sauces = new ArrayList<>();
        for (String sauceName : pizzaDTO.getSauces()) {
            Sauce sauce = Sauce.valueOf(sauceName.toUpperCase());
            sauces.add(sauce);
        }

        // Process toppings
        ArrayList<Topping> toppings = new ArrayList<>();
        for (String toppingName : pizzaDTO.getToppings()) {
            Topping topping = Topping.valueOf(toppingName.toUpperCase());
            toppings.add(topping);
        }

        Pizza pizza = new Pizza(crust, sauces, toppings);
        pizza.setItemName(pizzaDTO.getItemName());
        return pizza;
    }
}