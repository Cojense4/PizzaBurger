package com.prog02.pizza_burger.pizza.toppings;

public class MeatBeef extends MeatTopping {
    public MeatBeef(double price) {
        super(price);
    }

    public MeatBeef() {
        super(5.00);
    }

    @Override
    public String toString() {
        return "Beef Meat";
    }
    
}
