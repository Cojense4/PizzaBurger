package com.prog02.pizza_burger.dto;

import java.util.List;

public class PizzaDTO {
    private String itemName;
    private String crust;
    private List<String> sauces;
    private List<String> toppings;

    // Getters and Setters
    public String getItemName() { return itemName; }
    public String getCrust() { return crust; }
    public List<String> getSauces() { return sauces; }
    public List<String> getToppings() { return toppings; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setCrust(String crust) { this.crust = crust; }
    public void setSauces(List<String> sauces) { this.sauces = sauces; }
    public void setToppings(List<String> toppings) { this.toppings = toppings; }
}