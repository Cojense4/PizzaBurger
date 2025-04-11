package com.prog02.pizza_burger.repository;

import com.prog02.pizza_burger.model.pizza.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PizzaRepositoryTest {
    @Autowired
    private PizzaRepository pizzaRepository;

    @Test
    @Transactional
    public void testPizzaCreationFromTemplate() {
        // Given a PizzaTemplate (e.g., PEPPERONI) with certain enum values for crust, sauces, and toppings
        Pizza pizza = PizzaTemplate.PEPPERONI.toPizza("Custom Pepperoni");

        // Then check the basic properties
        assertEquals("Custom Pepperoni", pizza.getItemName());
        // Verify that the crust is correctly set (assume PEPPERONI template has a specific crust)
        assertNotNull(pizza.getCrust());
        // Check that the list of sauces is exactly what you expect from the template
        assertTrue(pizza.getSauces().size() <= 2);
        // Check the toppings list size – should be at most 8
        assertTrue(pizza.getToppings().size() <= 8);
    }

    @Test
    @Transactional
    public void testPizzaPersistenceAndRetrieval() {
        // Create a Pizza using the template
        Pizza pizza = PizzaTemplate.PEPPERONI.toPizza("Pepperoni Special");

        // Assert id is null before saving (JPA will assign an id on persist)
        assertNull(pizza.getId(), "Pizza id should be null before saving");

        // Persist the pizza via the repository
        Pizza savedPizza = pizzaRepository.save(pizza);

        // Assert that the pizza has a generated id after saving
        assertNotNull(savedPizza.getId(), "Pizza should have an id after persistence");

        // Retrieve the pizza using its id and verify its properties
        Pizza retrievedPizza = pizzaRepository.findById(savedPizza.getId()).orElse(null);
        assertNotNull(retrievedPizza, "The retrieved pizza should not be null");
        assertEquals("Pepperoni Special", retrievedPizza.getItemName(), "Item name should match");

        // Ensure that collections were persisted (sauces and toppings)
        assertNotNull(retrievedPizza.getSauces(), "Sauces collection should be persisted");
        assertFalse(retrievedPizza.getSauces().isEmpty(), "There should be at least one sauce");
        assertNotNull(retrievedPizza.getToppings(), "Toppings collection should be persisted");
    }

    @Test
    public void testSauceAndToppingConstraints() {
        Pizza pizza = new Pizza();
        // Creating a list of sauces with more than 2 elements should trigger an error.
        List<Sauce> tooManySauces = new ArrayList<>();
        tooManySauces.add(Sauce.ALFREDO);
        tooManySauces.add(Sauce.TRADITIONAL);
        tooManySauces.add(Sauce.MEAT); // Third sauce

        Exception sauceException = assertThrows(IllegalArgumentException.class, () -> {
            pizza.setSauces(tooManySauces);
        });
        assertTrue(sauceException.getMessage().contains("Cannot have more than 2 sauces"));

        // Similarly for toppings, create a list with more than 8 elements.
        List<Topping> tooManyToppings = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            // Assuming you have a valid enum value for Topping, or you can reuse one value repeatedly if testing only the constraint
            tooManyToppings.add(Topping.PEPPERONI);
        }
        Exception toppingException = assertThrows(IllegalArgumentException.class, () -> {
            pizza.setToppings(tooManyToppings);
        });
        assertTrue(toppingException.getMessage().contains("Cannot have more than 8 toppings"));
    }
}