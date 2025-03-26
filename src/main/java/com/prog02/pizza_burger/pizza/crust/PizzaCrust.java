package com.prog02.pizza_burger.pizza.crust;
import com.prog02.pizza_burger.common.Priceable;


abstract public class PizzaCrust extends Priceable {
    protected String ingredient;
    protected double price;

    @Override
    abstract public String toString();

    public PizzaCrust(String ingredient, double price) {
        super(price);
        this.ingredient = ingredient;
        this.price = price;
    }

    public PizzaCrust(String ingredient) {
        this(ingredient, 5.00);
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public String toNiceString() {
        return "Crust is: " + toString() + "\n" + "Ingredients: " + this.ingredient;
    }
    
}
