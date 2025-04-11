package com.prog02.pizza_burger.dto;

import java.util.List;

public class BurgerDTO {
    private String itemName;
    private String bun;
    private List<String> patties;
    private List<String> cheeses;
    private List<String> garnishes;


    // Getters and Setters
    public String getItemName() { return itemName; }
    public String getBun() { return bun; }
    public List<String> getPatties() { return patties; }
    public List<String> getCheeses() { return cheeses; }
    public List<String> getGarnishes() { return garnishes; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setBun(String bun) { this.bun = bun; }
    public void setPatties(List<String> patties) { this.patties = patties; }
    public void setCheeses(List<String> cheeses) { this.cheeses = cheeses; }
    public void setGarnishes(List<String> garnishes) { this.garnishes = garnishes; }
}