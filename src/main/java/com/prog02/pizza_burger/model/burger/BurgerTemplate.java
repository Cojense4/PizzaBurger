package com.prog02.pizza_burger.model.burger;

import com.prog02.pizza_burger.model.common.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BurgerTemplate implements MenuItem {
    DEFAULT (
            "Default Burger",
            Bun.BRIOCHE,
            new ArrayList<>(List.of(Patty.BEEF)),
            new ArrayList<>(List.of(Cheese.AMERICAN)),
            new ArrayList<>()
    ),
    CHZ_BURG(
            "Cheeseburger",
            Bun.SESAME,
            new ArrayList<>(List.of(Patty.BEEF)),
            new ArrayList<>(Arrays.asList(Cheese.GOUDA, Cheese.AMERICAN)),
            new ArrayList<>(Arrays.asList(Garnish.LETTUCE, Garnish.TOMATO, Garnish.PICKLES, Garnish.ONION))
    ),
    BACON_CHZ_BURG(
            "Bacon Cheeseburger",
            Bun.SESAME,
            new ArrayList<>(List.of(Patty.BEEF)),
            new ArrayList<>(Arrays.asList(Cheese.GOUDA, Cheese.AMERICAN)),
            new ArrayList<>(Arrays.asList(Garnish.LETTUCE, Garnish.TOMATO, Garnish.PICKLES, Garnish.ONION))
    ),
    DOUBLE_DOUBLE (
            "Double Double",
            Bun.BRIOCHE,
            new ArrayList<>(List.of(Patty.BEEF, Patty.BEEF)),
            new ArrayList<>(List.of(Cheese.AMERICAN, Cheese.AMERICAN)),
            new ArrayList<>(List.of(Garnish.ONION, Garnish.LETTUCE, Garnish.TOMATO))
    ),
    BIG_BURG(
            "King Burger",
            Bun.BRIOCHE,
            new ArrayList<>(Arrays.asList(Patty.BEEF, Patty.BEEF)),
            new ArrayList<>(Arrays.asList(Cheese.AMERICAN, Cheese.GOUDA, Cheese.CHEDDAR, Cheese.AMERICAN)),
            new ArrayList<>(Arrays.asList(Garnish.LETTUCE, Garnish.TOMATO, Garnish.PICKLES, Garnish.ONION))
    );
    // Add more templates as needed

    private final String itemName;
    private final Bun bun;
    private final ArrayList<Patty> patties;
    private final ArrayList<Cheese> cheeses;
    private final ArrayList<Garnish> garnishes;

    BurgerTemplate(String itemName, Bun bun, ArrayList<Patty> patties, ArrayList<Cheese> cheeses, ArrayList<Garnish> garnishes) {
        this.itemName = itemName;
        this.bun = bun;
        this.patties = patties;
        this.cheeses = cheeses;
        this.garnishes = garnishes;
    }

    /**
     * Returns a new Burger instance based on the template.
     */
    public Burger toBurger() {
        Burger newBurg = new Burger(
                bun,
                new ArrayList<>(this.patties),
                new ArrayList<>(this.cheeses),
                new ArrayList<>(this.garnishes)
        );
        newBurg.setItemName(itemName);
        return newBurg;
    }

    @Override
    public double getPrice() {
        double totalPrice = 0.0;
        totalPrice += bun.getPrice();
        for (Patty patty : patties) {
            totalPrice += patty.getPrice();
        }
        for (Cheese cheese : cheeses) {
            totalPrice += cheese.getPrice();
        }
        for (Garnish garnish : garnishes) {
            totalPrice += garnish.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String getName() {
        return itemName;
    }
    public Bun getBun() {
        return bun;
    }
    public ArrayList<Patty> getPatties() {
        return patties;
    }
    public ArrayList<Cheese> getCheeses() {
        return cheeses;
    }
    public ArrayList<Garnish> getGarnishes() {
        return garnishes;
    }
}