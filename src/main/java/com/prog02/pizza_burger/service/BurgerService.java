package com.prog02.pizza_burger.service;

import com.prog02.pizza_burger.dto.BurgerDTO;
import com.prog02.pizza_burger.model.common.MenuItem;
import com.prog02.pizza_burger.model.burger.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class BurgerService {

    public Burger createBurger(BurgerDTO burgerDTO) {
        Bun bun = MenuItem.fromItemName(Bun.class, burgerDTO.getItemName());

        // Process patties
        ArrayList<Patty> patties = new ArrayList<>();
        for (String pattyName : burgerDTO.getPatties()) {
            Patty patty = Patty.valueOf(pattyName.toUpperCase());
            // Optionally use additional DTO info like seasoning and cook level here
            patties.add(patty);
        }

        // Process cheeses
        ArrayList<Cheese> cheeses = new ArrayList<>();
        for (String cheeseName : burgerDTO.getCheeses()) {
            Cheese cheese = Cheese.valueOf(cheeseName.toUpperCase());
            cheeses.add(cheese);
        }

        // Process garnishes
        ArrayList<Garnish> garnishes = new ArrayList<>();
        for (String garnishName : burgerDTO.getGarnishes()) {
            Garnish garnish = Garnish.valueOf(garnishName.toUpperCase());
            garnishes.add(garnish);
        }

        Burger newBurger = new Burger(bun, patties, cheeses, garnishes);
        newBurger.setItemName(burgerDTO.getItemName());
        return newBurger;
    }

}