package com.prog02.pizza_burger.pizza.toppings;

public class VeggiePepper extends VeggieTopping {  
    public VeggiePepper(double price) {
        super(price);
    }
    public VeggiePepper() {
        super(1.25);
    }

    @Override
    public String toString() {
        return "Banana Pepper";
    }
    
}
