package com.prog02.pizza_burger.pizza.toppings;

public class MeatTopping extends PizzaTopping {

    public MeatTopping(double price) {
        super(price);
    }

    @Override
    public String toString() {
        return "MeatTopping";
    }

    @Override
    public String toNiceString() {
        return "Meat topping is: " + toString();
    }
}