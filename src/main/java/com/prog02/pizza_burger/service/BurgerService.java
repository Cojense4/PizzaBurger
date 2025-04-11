package com.prog02.pizza_burger.service;

import com.prog02.pizza_burger.dto.BurgerDTO;
import com.prog02.pizza_burger.model.burger.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class BurgerService {

    public Burger createBurger(BurgerDTO burgerDTO) {
        // Convert DTO values into enum instances; for simplicity, assume the names match.
        Bun bun = convertToBun(burgerDTO.getBun());

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
        // Optionally: compare against BurgerTemplate for template matching

        return newBurger;
    }

    private Bun convertToBun(String bunName) {
        for (Bun bun : Bun.values()) {
            if (bun.getName().equalsIgnoreCase(bunName)) {
                return bun;
            }
        }
        // Fallback to a default bun if conversion fails:
        return Bun.BRIOCHE;
    }
}