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
    private final List<Patty> patties;
    private final List<Cheese> cheeses;
    private final List<Garnish> garnishes;

    BurgerTemplate(String itemName, Bun bun, List<Patty> patties, List<Cheese> cheeses, List<Garnish> garnishes) {
        this.itemName = itemName;
        this.bun = bun;
        this.patties = patties;
        this.cheeses = cheeses;
        this.garnishes = garnishes;
    }

    /**
     * Returns a new Burger instance based on the template.
     */
    public Burger getBurger(String burgerName) {
        BurgerTemplate burgerTemplate = MenuItem.fromItemName(BurgerTemplate.class, burgerName);
        Burger burg = new Burger(
                bun,
                new ArrayList<>(burgerTemplate.patties),
                new ArrayList<>(burgerTemplate.cheeses),
                new ArrayList<>(burgerTemplate.garnishes)
        );
        burg.customize(burgerTemplate.itemName);
        return burg;
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
        return this.bun;
    }

    public List<Patty> getPatties() {
        return patties;
    }
    public List<Cheese> getCheeses() {
        return cheeses;
    }
    public List<Garnish> getGarnishes() {
        return garnishes;
    }
}