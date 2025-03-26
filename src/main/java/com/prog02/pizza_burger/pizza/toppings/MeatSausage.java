package com.prog02.pizza_burger.pizza.toppings;

public class MeatSausage extends MeatTopping {
    public MeatSausage(double price) {
        super(price);
    }

    public MeatSausage() {
        super(6.50);
    }

    @Override
    public String toString() {
        return "Sausage Meat";
    }
    
}
