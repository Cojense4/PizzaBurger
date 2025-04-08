package com.prog02.pizza_burger.model.pizza;

import com.prog02.pizza_burger.model.common.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PizzaTemplate implements MenuItem {
    CHEESE(
            "Cheese Pizza",
            Crust.TRADITIONAL,
            new ArrayList<>(List.of(Sauce.TRADITIONAL)),
            new ArrayList<>(Arrays.asList(Topping.MOZZERELLA, Topping.GRUYERE)), 
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>()
                        ),
    PEPPERONI(
            "Pepperoni Pizza",
            Crust.TRADITIONAL,
            new ArrayList<>(List.of(Sauce.TRADITIONAL)),
            new ArrayList<>(Arrays.asList(Topping.MOZZERELLA, Topping.PROVALONE)),
            new ArrayList<>(List.of(Topping.PEPPERONI)),
            new ArrayList<>(),
            new ArrayList<>()
    ),
    SUPREME(
            "Supreme Pizza",
            Crust.TRADITIONAL,
            new ArrayList<>(List.of(Sauce.MEAT)),
            new ArrayList<>(Arrays.asList(Topping.MOZZERELLA, Topping.PROVALONE)),
            new ArrayList<>(Arrays.asList(Topping.PEPPERONI, Topping.BEEF)),
            new ArrayList<>(Arrays.asList(Topping.OLIVES, Topping.PEPPER)),
            new ArrayList<>(Arrays.asList(Topping.SAUSAGE, Topping.MUSHROOM))
    ),
    VEG_LOVER(
            "Veggie Lover Pizza",
            Crust.CAULIFLOWER,
            new ArrayList<>(List.of(Sauce.SAUCELESS)),
            new ArrayList<>(List.of(Topping.VEGAN_MOZZ)),
            new ArrayList<>(),
            new ArrayList<>(Arrays.asList(Topping.MUSHROOM, Topping.OLIVES)),
            new ArrayList<>(Arrays.asList(Topping.PEPPER, Topping.TOMATO))
    );

    private final String itemName;
    private final Crust crust;
    private final ArrayList<Sauce> sauces;
    private final ArrayList<Topping> chzToppings;
    private final ArrayList<Topping> meatToppings;
    private final ArrayList<Topping> vegToppings;
    private final ArrayList<Topping> extraToppings;
    private final ArrayList<Topping> allToppings;

    PizzaTemplate(String itemName, Crust crust, ArrayList<Sauce> sauces, ArrayList<Topping> chzToppings, ArrayList<Topping> meatToppings, ArrayList<Topping> vegToppings, ArrayList<Topping> extraToppings) {
        this.itemName = itemName;
        this.crust = crust;
        this.sauces = sauces;
        this.chzToppings = chzToppings;
        this.meatToppings = meatToppings;
        this.vegToppings = vegToppings;
        this.extraToppings = extraToppings;
        this.allToppings = getToppings();
    }

    /**
     * Returns a new Pizza instance based on the template.
     */
    public Pizza toPizza(String pizzaName) {
        PizzaTemplate pizTemplate = MenuItem.fromItemName(PizzaTemplate.class, pizzaName);
        Pizza newPiz = new Pizza(
                pizTemplate.crust,
                new ArrayList<>(pizTemplate.sauces),
                new ArrayList<>(pizTemplate.allToppings)
        );
        newPiz.setItemName(itemName);
        return newPiz;
    }

    @Override
    public double getPrice() {
        double totalPrice = 0.0;
        totalPrice += this.crust.getPrice();
        for (Sauce sauce : this.sauces) {
            totalPrice += sauce.getPrice();
        }
        for (Topping topping : this.allToppings) {
            totalPrice += topping.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String getName() {
        return itemName;
    }
    public Crust getCrust() { return crust; }
    public ArrayList<Sauce> getSauces() { return sauces; }
    public ArrayList<Topping> getChzToppings() { return chzToppings; }
    public ArrayList<Topping> getMeatToppings() { return meatToppings; }
    public ArrayList<Topping> getVegToppings() { return vegToppings; }
    public ArrayList<Topping> getExtraToppings() { return extraToppings; }
    public ArrayList<Topping> getToppings() {
        ArrayList<Topping> allToppings = new ArrayList<>();
        allToppings.addAll(this.chzToppings);
        allToppings.addAll(this.meatToppings);
        allToppings.addAll(this.vegToppings);
        allToppings.addAll(this.extraToppings);
        return allToppings;
    }
}
