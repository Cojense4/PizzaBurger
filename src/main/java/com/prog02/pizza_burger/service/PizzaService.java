package com.prog02.pizza_burger.service;

import com.prog02.pizza_burger.dto.PizzaDTO;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.pizza.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class PizzaService {

    public static Pizza createPizza(PizzaDTO pizzaDTO) {
        Crust crust = MenuItem.fromItemName(Crust.class, pizzaDTO.getItemName());

        // Process sauces
        ArrayList<Sauce> sauces = new ArrayList<>();
        for (String sauceDTO : pizzaDTO.getSauces()) {
            System.out.println("Sauce: " + sauceDTO);
            Sauce sauce = Sauce.valueOf(sauceDTO.toUpperCase());
            sauces.add(sauce);
        }

        // Process toppings
        ArrayList<Topping> toppings = new ArrayList<>();
        for (String toppingName : pizzaDTO.getToppings()) {
            Topping topping = Topping.valueOf(toppingName.toUpperCase());
            toppings.add(topping);
        }

        Pizza newPizza = new Pizza(crust, sauces, toppings);
        newPizza.setItemName(pizzaDTO.getItemName());
        return newPizza;
    }
}