package com.prog02.pizza_burger.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.prog02.pizza_burger.model.common.Priceable;
import com.prog02.pizza_burger.model.pizza.*;
import org.junit.jupiter.api.Test;

import com.prog02.pizza_burger.model.common.MenuItem;

public class PizzaTest {

    @Test
    public void testPizzaComponents() {
        // Using enums for Crust, Sauce, and Topping.
        Crust testCrust = Crust.THIN;
        ArrayList<Sauce> testSauces = new ArrayList<>();
        testSauces.add(Sauce.TRADITIONAL);
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.MUSHROOM);

        // Instantiate a Pizza object.
        Pizza testPizza = new Pizza(testCrust, testSauces, toppings);
        assertNotNull(testPizza, "Pizza should be instantiated successfully");

        // Calculate the expected price (sum of components).
        double expectedPrice = testCrust.getPrice();
        for (MenuItem sauce : testSauces) {
            expectedPrice += sauce.getPrice();
        }
        for (MenuItem topping : toppings) {
            expectedPrice += topping.getPrice();
        }

        // Assert that the pizza price matches the expected price.
        assertEquals(expectedPrice, testPizza.getPrice(), 0.001, "Pizza price should be the sum of its components");
    }

    @Test
    public void testPizzaDisplay() {
        // Using enums for Crust, Sauce, and Topping.
        Crust testCrust = Crust.THIN;
        ArrayList<Sauce> testSauces = new ArrayList<>();
        testSauces.add(Sauce.TRADITIONAL);
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.MUSHROOM);

        // Instantiate a Pizza object.
        Pizza testPizza = new Pizza(testCrust, testSauces, toppings);

        // Build the expected display string.
        StringBuilder expectedDisplay = new StringBuilder();
        expectedDisplay.append("---------- Pizza ----------\n");
        expectedDisplay.append(testCrust.display()).append("\n");
        if (!testSauces.isEmpty()) {
            expectedDisplay.append("--- Sauces ---\n");
            for (Sauce sauce : testSauces) {
                expectedDisplay.append(sauce.display()).append("\n");
            }
        }
        if (!toppings.isEmpty()) {
            expectedDisplay.append("Toppings:\n");
            for (Topping topping : toppings) {
                expectedDisplay.append(topping.display()).append("\n");
            }
        }

        // Assert that the display output matches the expected output.
        assertEquals(expectedDisplay.toString(), testPizza.display(), "Pizza display output should match expected output");
    }

    @Test
    public void testPizzaComponentsWithNoToppings() {
        // Test pizza with an empty toppings list.
        Crust testCrust = Crust.CAULIFLOWER;
        Sauce testSauces = Sauce.GARLIC;
        ArrayList<Topping> emptyToppings = new ArrayList<>();

        Pizza testPizza = new Pizza(testCrust, testSauces, emptyToppings);
        assertNotNull(testPizza, "Pizza should be instantiated successfully with no toppings");

        // Expected price is just crust + sauce.
        double expectedPrice = testCrust.getPrice() + testSauces.getPrice();
        assertEquals(expectedPrice, testPizza.getPrice(), 0.001, "Pizza price with no toppings should be sum of crust and sauce");

        // Expected display should not include the 'Toppings:' section.
        StringBuilder expectedDisplay = new StringBuilder();
        expectedDisplay.append("---------- Pizza ----------\n");
        expectedDisplay.append(testCrust.display()).append("\n");
        expectedDisplay.append(testSauces.display()).append("\n");
        assertEquals(expectedDisplay.toString(), testPizza.display(), "Pizza display should not include toppings when list is empty");
    }

    @Test
    public void testCustomizeSauceEffectOnPizza() {
        // Test that customizing a sauce affects the pizza price and display.
        Crust testCrust = Crust.TRADITIONAL;
        Sauce testSauces = Sauce.TRADITIONAL;
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(Topping.BACON);
        toppings.add(Topping.OLIVES);

        // Save the original price to restore later.
        double originalPrice = testSauces.getPrice();
        try {
            // Customize the sauce: change price to 6.00.
            testSauces.customizeSauce(6.00, 3);
            Pizza testPizza = new Pizza(testCrust, testSauces, toppings);

            // Expected price calculation.
            double expectedPrice = testCrust.getPrice() + testSauces.getPrice();
            for (MenuItem topping : toppings) {
                expectedPrice += topping.getPrice();
            }
            assertEquals(expectedPrice, testPizza.getPrice(), 0.001, "Pizza price should reflect customized sauce price");

            // Verify display reflects the customized sauce price.
            String expectedSauceDisplay = testSauces.getName() + " (" + String.format("%.2f", testSauces.getPrice()) + ")";
            assertTrue(testPizza.display().contains(expectedSauceDisplay), "Pizza display should include the customized sauce price");
        } finally {
            // Restore the original sauce price (assuming quantity remains unchanged for simplicity).
            testSauces.customizeSauce(originalPrice, 2);
        }
    }

    @Test
    public void testComponentDisplayFormatting() {
        // Test display formatting for individual components.
        String crustDisplay = Crust.THIN.display();
        assertEquals("Thin Crust (4.50)", crustDisplay, "Crust display should match expected format");

        String sauceDisplay = Sauce.ALFREDO.display();
        assertEquals("Alfredo Sauce (3.75)", sauceDisplay, "Sauce display should match expected format");

        String toppingDisplay = Topping.PEPPERONI.display();
        assertEquals("Pepperoni Meat (1.50)", toppingDisplay, "Topping display should match expected format");
    }

    @Test
    public void testPizzaWithNullToppings() {
        // Test behavior when null is passed for toppings.
        Crust testCrust = Crust.THIN;
        Sauce testSauces = Sauce.TRADITIONAL;
        Pizza testPizza = new Pizza(testCrust, testSauces, null);

        // Expected display: should only include crust and sauce.
        StringBuilder expectedDisplay = new StringBuilder();
        expectedDisplay.append("---------- Pizza ----------\n");
        expectedDisplay.append(testCrust.display()).append("\n");
        expectedDisplay.append(testSauces.display()).append("\n");
        assertEquals(expectedDisplay.toString(), testPizza.display(), "Pizza display should handle null toppings gracefully");

        // getPrice() should throw a NullPointerException since toppings is null.
        assertThrows(NullPointerException.class, testPizza::getPrice, "getPrice should throw NullPointerException when toppings is null");
    }

    @Test
    public void testPizzaSortedComponents() {
        // Create a Pizza with components that are not in sorted order.
        Crust testCrust = Crust.THICK;      // Price: 7.00
        Sauce testSauces = Sauce.ALFREDO;    // Price: 3.75
        ArrayList<Topping> toppings = new ArrayList<>();
        toppings.add(Topping.BACON);         // Price: 3.50
        toppings.add(Topping.PEPPERONI);     // Price: 1.50
        toppings.add(Topping.TOMATO);        // Price: 1.50

        Pizza testPizza = new Pizza(testCrust, testSauces, toppings);

        // Use the sorting method provided in Pizza.
        ArrayList<Priceable> sortedComponents = testPizza.getSortedComponents();
        for (int i = 0; i < sortedComponents.size() - 1; i++) {
            double currentPrice = sortedComponents.get(i).getPrice();
            double nextPrice = sortedComponents.get(i + 1).getPrice();
            assertTrue(currentPrice <= nextPrice, "Component at index " + i + " (" + currentPrice + ") should be less than or equal to component at index " + (i+1) + " (" + nextPrice + ")");
        }
    }
}