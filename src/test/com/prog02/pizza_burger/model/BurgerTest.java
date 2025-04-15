package com.prog02.pizza_burger.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import com.prog02.pizza_burger.model.burger.*;
import org.junit.jupiter.api.Test;

import com.prog02.pizza_burger.model.common.Priceable;

public class BurgerTest {

    @Test
    public void testBurgerPriceCalculation() {
        // Testing default prices for burger templates.
        Bun testBun = Bun.SESAME; // e.g., price: 3.00
        ArrayList<Patty> patties = new ArrayList<>();
        patties.add(Patty.BEEF); // e.g., price: 5.00
        ArrayList<Cheese> cheeses = new ArrayList<>();
        cheeses.add(Cheese.AMERICAN); // e.g., price: 1.00 (default)
        ArrayList<Garnish> garnishes = new ArrayList<>();
        garnishes.add(Garnish.TOMATO); // e.g., price: 1.25

        Burger testBurger = new Burger(testBun, patties, cheeses, garnishes);

        double expectedPrice = testBun.getPrice() + Patty.BEEF.getPrice() + Cheese.AMERICAN.getPrice() + Garnish.TOMATO.getPrice();
        assertEquals(expectedPrice, testBurger.getPrice(), 0.001, "Burger price should be the sum of its components");
    }

    @Test
    public void testBurgerDisplay() {
        // Build a burger with multiple components.
        Bun testBun = Bun.BRIOCHE; // e.g., price: 4.00
        ArrayList<Patty> patties = new ArrayList<>();
        patties.add(Patty.CHICKEN); // e.g., price: 3.50
        ArrayList<Cheese> cheeses = new ArrayList<>();
        cheeses.add(Cheese.GOUDA); // e.g., price: 1.50
        ArrayList<Garnish> garnishes = new ArrayList<>();
        garnishes.add(Garnish.LETTUCE); // e.g., price: 0.00
        garnishes.add(Garnish.PICKLES); // e.g., price: 0.25

        Burger testBurger = new Burger(testBun, patties, cheeses, garnishes);

        StringBuilder expectedDisplay = new StringBuilder();
        expectedDisplay.append("---------- null ----------\n");
        expectedDisplay.append(testBun.display()).append("\n");
        if (!patties.isEmpty()) {
            for (Patty patty : patties) {
                expectedDisplay.append(patty.display()).append("\n");
            }
        }
        if (!cheeses.isEmpty()) {
            for (Cheese cheese : cheeses) {
                expectedDisplay.append(cheese.display()).append("\n");
            }
        }
        if (!garnishes.isEmpty()) {
            expectedDisplay.append("--- garnishes ---\n");
            for (Garnish garnish : garnishes) {
                expectedDisplay.append(garnish.display()).append("\n");
            }
        }
        assertEquals(expectedDisplay.toString(), testBurger.display(), "Burger display output should match expected output");
    }

    @Test
    public void testBurgerWithEmptyComponents() {
        // Test a burger built with empty patties, cheeses, and garnishes.
        Bun testBun = Bun.POTATO; // e.g., price: 3.75
        ArrayList<Patty> emptyPatties = new ArrayList<>();
        ArrayList<Cheese> emptyCheeses = new ArrayList<>();
        ArrayList<Garnish> emptyGarnishes = new ArrayList<>();

        Burger testBurger = new Burger(testBun, emptyPatties, emptyCheeses, emptyGarnishes);

        double expectedPrice = testBun.getPrice();
        assertEquals(expectedPrice, testBurger.getPrice(), 0.001, "Burger price with empty components should equal bun price");

        StringBuilder expectedDisplay = new StringBuilder();
        expectedDisplay.append("---------- null ----------\n");
        expectedDisplay.append(testBun.display()).append("\n");
        assertEquals(expectedDisplay.toString(), testBurger.display(), "Burger display with empty components should only include bun");
    }

    @Test
    public void testCustomizeCheeseEffectOnBurger() {
        // Test that customizing a cheese affects the burger's price and display.
        Bun testBun = Bun.SOURDOUGH; // e.g., price: 4.25
        ArrayList<Patty> patties = new ArrayList<>();
        patties.add(Patty.WAGYU); // e.g., price: 10.00
        ArrayList<Cheese> cheeses = new ArrayList<>();
        cheeses.add(Cheese.AMERICAN); // e.g., price: 1.75 (default)
        ArrayList<Garnish> garnishes = new ArrayList<>();
        garnishes.add(Garnish.ONION); // e.g., price: 0.25

        // Save original state of cheese.
        boolean originalIsSmoked = false; // assumed default for WHITE_AMERICAN
        boolean originalIsAged = false;    // assumed default
        double originalCheesePrice = Cheese.AMERICAN.getPrice();

        try {
            // Customize the cheese: setting smoked and aged should add 0.25+0.25 = 0.50.
            Cheese.AMERICAN.setIsAged(true);
            Cheese.AMERICAN.setIsSmoked(true);
            Burger testBurger = new Burger(testBun, patties, cheeses, garnishes);

            double expectedCheesePrice = originalCheesePrice + 0.50;
            double expectedPrice = testBun.getPrice() + Patty.WAGYU.getPrice() + expectedCheesePrice + Garnish.ONION.getPrice();
            assertEquals(expectedPrice, testBurger.getPrice(), 0.001, "Burger price should reflect customized cheese price");

            // Check that the display output reflects the updated cheese information.
            String expectedCheeseDisplay = "Smoked Aged " + Cheese.AMERICAN.getName();
            assertTrue(testBurger.display().contains(expectedCheeseDisplay), "Burger display should include updated cheese details");
        } finally {
            // Restore original cheese state.
            Cheese.AMERICAN.setIsAged(originalIsAged);
            Cheese.AMERICAN.setIsSmoked(originalIsSmoked);
        }
    }

    @Test
    public void testBurgerSortedComponents() {
        // Create a Burger with components that are not in sorted order.
        Bun testBun = Bun.SESAME; // e.g., price: 3.00
        ArrayList<Patty> patties = new ArrayList<>();
        patties.add(Patty.CHICKEN); // e.g., price: 3.50
        patties.add(Patty.BEEF); // e.g., price: 5.00
        ArrayList<Cheese> cheeses = new ArrayList<>();
        cheeses.add(Cheese.PEPPER_JACK); // e.g., price: 2.00
        ArrayList<Garnish> garnishes = new ArrayList<>();
        garnishes.add(Garnish.BACON); // e.g., price: 2.25 (non-veggie bacon)
        garnishes.add(Garnish.AVACADO); // e.g., price: 2.00 (Avocado Slices)

        Burger testBurger = new Burger(testBun, patties, cheeses, garnishes);

        ArrayList<Priceable> sortedComponents = testBurger.getSortedComponents();
        for (int i = 0; i < sortedComponents.size() - 1; i++) {
            double currentPrice = sortedComponents.get(i).getPrice();
            double nextPrice = sortedComponents.get(i + 1).getPrice();
            assertTrue(currentPrice <= nextPrice, "Component at index " + i + " (" + currentPrice +
                    ") should be less than or equal to component at index " + (i+1) + " (" + nextPrice + ")");
        }
    }
}