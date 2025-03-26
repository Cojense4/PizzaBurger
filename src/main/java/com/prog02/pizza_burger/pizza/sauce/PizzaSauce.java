package com.prog02.pizza_burger.pizza.sauce;
import com.prog02.pizza_burger.common.Priceable;

abstract public class PizzaSauce extends Priceable {
    protected double price;
    
    public PizzaSauce(double price) {
        super(price);
        this.price = price;
    }
    public PizzaSauce() {
        this(4);
    }

    @Override
    public String toString() {
        return "Pizza Sauce";
    }


    public String toNiceString() {
        return "Sauce is: " + toString();
    }
}
