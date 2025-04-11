package com.prog02.pizza_burger.model.burger;

import com.prog02.pizza_burger.model.common.AbstractMenuItem;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "burgers")
public class Burger extends AbstractMenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "bun")
    private Bun bun;

    @ElementCollection(targetClass = Patty.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "burger_patties", joinColumns = @JoinColumn(name = "burger_id"))
    @Column(name = "patty")
    private List<Patty> patties;

    @ElementCollection(targetClass = Cheese.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "burger_cheeses", joinColumns = @JoinColumn(name = "burger_id"))
    @Column(name = "cheese")
    private List<Cheese> cheeses;

    @ElementCollection(targetClass = Garnish.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "burger_garnishes", joinColumns = @JoinColumn(name = "burger_id"))
    @Column(name = "garnish")
    private List<Garnish> garnishes;

    // Default constructor
    public Burger() {
        this.bun = null;
        this.patties = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.garnishes = new ArrayList<>();
        this.price = 0.0;
    }
    public Burger(Bun bun, List<Patty> patties, List<Cheese> cheeses, List<Garnish> garnish) {
        this.bun = bun;
        this.patties = patties;
        this.cheeses = cheeses;
        this.garnishes = garnish;
        this.price = getPrice();
    }

    /**
     * Displays the Burger build as a printed receipt.
     */
    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("---------- %s ----------\n", itemName));
        // bun
        sb.append(bun.display()).append("\n");
        // Patties
        if (patties != null && !patties.isEmpty()) {
            for (Patty patty : patties) {
                sb.append(patty.display()).append("\n");
            }
        }
        // Cheeses
        if (cheeses != null && !cheeses.isEmpty()) {
            for (Cheese cheese : cheeses) {
                sb.append(cheese.display()).append("\n");
            }
        }
        // Garnishes
        if (garnishes != null && !garnishes.isEmpty()) {
            sb.append("--- garnishes ---\n");
            for (Garnish topping : garnishes) {
                sb.append(topping.display()).append("\n");
            }
        }
        return sb.toString();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    @Override
    public double getPrice() {
        double totalPrice = 0.0;
        totalPrice += bun.getPrice();
        for (Patty patty : patties) {
            totalPrice += patty.getPrice();
        }
        for (Cheese cheese : cheeses) {
            totalPrice += cheese.getPrice();
        }
        for (Garnish garnish : garnishes) {
            totalPrice += garnish.getPrice();
        }
        return totalPrice;
    }
    public String getItemName() {return itemName;}
    public Bun getBun() { return bun; }
    public List<Patty> getPatties() { return patties; }
    public List<Cheese> getCheeses() { return cheeses; }
    public List<Garnish> getGarnishes() { return garnishes; }

    public void setItemName(String newItemName) {
        this.itemName = newItemName;
    }
    public void setBun(Bun bun) { this.bun = bun; }
    public void setPatties(List<Patty> patties) {
        if (patties != null && patties.size() > 4) {
            throw new IllegalArgumentException("Cannot have more than 4 patties");
        }
        this.patties = patties;
    }
    public void setCheeses(List<Cheese> cheeses) {
        if (cheeses != null && cheeses.size() > 4) {
            throw new IllegalArgumentException("Cannot have more than 4 cheeses");
        }
        this.cheeses = cheeses;
    }
    public void setGarnishes(List<Garnish> garnishes) {
        if (garnishes != null && garnishes.size() > 8) {
            throw new IllegalArgumentException("Cannot have more than 8 garnishes");
        }
        this.garnishes = garnishes;
    }
}
