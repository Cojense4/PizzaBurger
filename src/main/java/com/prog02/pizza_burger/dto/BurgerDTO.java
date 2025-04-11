package com.prog02.pizza_burger.dto;

import java.util.List;

public class BurgerDTO {
    private String itemName;
    private String bun;
    private List<String> patties;
    private List<String> cheeses;
    private List<String> garnishes;

    // Optionally, add fields for extra details per patty/cheese (e.g., cook level, seasoning)

    // Getters and Setters
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getBun() { return bun; }
    public void setBun(String bun) { this.bun = bun; }

    public List<String> getPatties() { return patties; }
    public void setPatties(List<String> patties) { this.patties = patties; }

    public List<String> getCheeses() { return cheeses; }
    public void setCheeses(List<String> cheeses) { this.cheeses = cheeses; }

    public List<String> getGarnishes() { return garnishes; }
    public void setGarnishes(List<String> garnishes) { this.garnishes = garnishes; }
}