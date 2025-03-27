package com.prog02.pizza_burger.pizza.toppings;
import com.prog02.pizza_burger.common.Priceable;

public abstract class PizzaTopping extends Priceable {
	protected double price;
	protected String itemName;

	public PizzaTopping(double price, String itemName) {
		super(price, itemName);
		this.price = price;
		this.itemName = itemName;
	}
}