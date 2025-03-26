package com.prog02.pizza_burger.pizza.toppings;
import com.prog02.pizza_burger.common.Priceable;

public abstract class PizzaTopping extends Priceable {
	protected double price;
	
	@Override
    public abstract String toString(); 

	public PizzaTopping(double price) {
		super(price);
		this.price = price;
	}
	
	@Override
	public double getPrice() {
		return this.price;
	}

	public String toNiceString() {
		return "Topping is: " + toString();
	}
}