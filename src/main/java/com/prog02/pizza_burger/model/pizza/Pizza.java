package com.prog02.pizza_burger.model.pizza;

import jakarta.persistence.*;
import com.prog02.pizza_burger.model.common.AbstractMenuItem;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizza extends AbstractMenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    // Crust represented as an enum (e.g., THIN, THICK, STUFFED, GLUTEN_FREE)
    @Enumerated(EnumType.STRING)
    @Column(name = "crust")
    private Crust crust;

    // Up to 2 sauces – stored as a list of Sauce enum values.
    @ElementCollection(targetClass = Sauce.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "pizza_sauces", joinColumns = @JoinColumn(name = "pizza_id"))
    @Column(name = "sauce")
    private List<Sauce> sauces = new ArrayList<>();

    // Up to 8 toppings – stored as a list of Topping enum values.
    @ElementCollection(targetClass = Topping.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "pizza_toppings", joinColumns = @JoinColumn(name = "pizza_id"))
    @Column(name = "topping")
    private List<Topping> toppings = new ArrayList<>();


    // Default constructor
    public Pizza() {
    }
    public Pizza(Crust crust, ArrayList<Sauce> sauces, ArrayList<Topping> toppings) {
        this.crust = crust;
        this.sauces = sauces;
        this.toppings = toppings;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public String getItemName() {
        return itemName;
    }
    public Crust getCrust() {
        return crust;
    }
    public List<Sauce> getSauces() {
        return sauces;
    }
    public List<Topping> getToppings() {
        return toppings;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setCrust(Crust crust) {
        this.crust = crust;
    }
    public void setSauces(List<Sauce> sauces) {
        if (sauces != null && sauces.size() > 2) {
            throw new IllegalArgumentException("Cannot have more than 2 sauces");
        }
        this.sauces = sauces;
    }
    public void setToppings(List<Topping> toppings) {
        if (toppings != null && toppings.size() > 8) {
            throw new IllegalArgumentException("Cannot have more than 8 toppings");
        }
        this.toppings = toppings;
    }
    public void addSauce(Sauce sauce) {
        if (this.sauces.size() >= 2) {
            throw new IllegalArgumentException("Cannot add more than 2 sauces");
        }
        this.sauces.add(sauce);
    }
    public void addTopping(Topping topping) {
        if (this.toppings.size() >= 8) {
            throw new IllegalArgumentException("Cannot add more than 8 toppings");
        }
        this.toppings.add(topping);
    }
}