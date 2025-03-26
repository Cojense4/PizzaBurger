package com.prog02.pizza_burger.pizza.toppings;

public class VeggieMushroom extends VeggieTopping {
    public VeggieMushroom(double price) {
        super(price);
    }

    public VeggieMushroom() {
        super(2.5);
    }

    @Override
    public String toString() {
        return "Mushroom Veggie Topping";
    }
    
}
