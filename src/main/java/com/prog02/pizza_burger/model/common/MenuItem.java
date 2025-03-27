package com.prog02.pizza_burger.model.common;

public interface MenuItem {
    double getPrice();
    String getName();
    String toNiceString();
}