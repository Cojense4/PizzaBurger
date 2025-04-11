package com.prog02.pizza_burger.model.order;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The type of the item, such as "Burger" or "Pizza"
    @Column(nullable = false)
    private String itemType;

    // The name of the item (e.g., "Cheeseburger" or "Margherita Pizza")
    @Column(nullable = false)
    private String itemName;

    // The computed price of the item
    @Column(nullable = false)
    private double price;

    // Additional details (stored as a JSON string, for example)
    @Lob
    @Column(columnDefinition = "text")
    private String details;

    // Timestamp for when the item was created/added
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // No-argument constructor for JPA (also used for JSON deserialization)
    public CartItem() {
        this.createdAt = LocalDateTime.now();
    }

    // Constructor with all properties (except the ID, which is generated)
    public CartItem(String itemType, String itemName, double price, String details) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.price = price;
        this.details = details;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}