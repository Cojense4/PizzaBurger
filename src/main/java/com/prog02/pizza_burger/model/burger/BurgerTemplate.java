package com.prog02.pizza_burger.model.burger;

import com.prog02.pizza_burger.model.common.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BurgerTemplate implements MenuItem {
    CHZ_BURG(
            "Cheese Burger",
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
    BIG_BURG(
            "Big Burger",
            Bun.BRIOCHE,
            new ArrayList<>(Arrays.asList(Patty.BEEF, Patty.BEEF)),
            new ArrayList<>(Arrays.asList(Cheese.AMERICAN, Cheese.GOUDA, Cheese.WHITE_AMERICAN, Cheese.AMERICAN)),
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
    public Burger toBurger(String burgerName) {
        BurgerTemplate burgerTemplate = MenuItem.fromItemName(BurgerTemplate.class, burgerName);
        Burger templateBurger = new Burger(
                bun,
                new ArrayList<>(burgerTemplate.patties),
                new ArrayList<>(burgerTemplate.cheeses),
                new ArrayList<>(burgerTemplate.garnishes)
        );
        templateBurger.setItemName(itemName);
        return templateBurger;
    }

    /**
     * Displays the Burger build as a printed receipt.
     */
    @Override
    public String display() {return "";}

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