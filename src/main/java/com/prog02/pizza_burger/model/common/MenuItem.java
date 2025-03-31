package com.prog02.pizza_burger.model.common;

public interface MenuItem {
    double getPrice();
    String getName();
    default void display() {
        System.out.println(getName() + " -- $" + String.format("%.2f", getPrice()));
    }
}