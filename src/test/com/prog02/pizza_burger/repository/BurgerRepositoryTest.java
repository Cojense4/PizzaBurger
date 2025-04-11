package com.prog02.pizza_burger.repository;

import com.prog02.pizza_burger.model.burger.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BurgerRepositoryTest {
    @Autowired
    private BurgerRepository burgerRepository;

    @Test
    @Transactional
    public void testBurgerCreationFromTemplate() {
        // Given a PizzaTemplate (e.g., PEPPERONI) with certain enum values for crust, sauces, and toppings
        Burger burger = BurgerTemplate.CHZ_BURG.toBurger("Custom CheeseBurger");

        // Then check the basic properties
        assertEquals("Cheeseburger", burger.getItemName());
        // Verify that the crust is correctly set (assume PEPPERONI template has a specific crust)
        assertNotNull(burger.getBun());
        // Check that the list of patties is exactly what you expect from the template
        assertTrue(burger.getPatties().size() <= 4);
        // Check that the list of cheeses is exactly what you expect from the template
        assertTrue(burger.getCheeses().size() <= 4);
        // Check the garnishes list size – should be at most 8
        assertTrue(burger.getGarnishes().size() <= 8);
    }

    @Test
    @Transactional
    public void testBurgerPersistenceAndRetrieval() {
        // Create a burger using the template
        Burger burger = BurgerTemplate.CHZ_BURG.toBurger("Cheeseburger");

        // Assert id is null before saving (JPA will assign an id on persist)
        assertNull(burger.getId(), "burger id should be null before saving");

        // Persist the burger via the repository
        Burger savedBurger = burgerRepository.save(burger);

        // Assert that the burger has a generated id after saving
        assertNotNull(savedBurger.getId(), "burger should have an id after persistence");

        // Retrieve the burger using its id and verify its properties
        Burger retrievedBurger = burgerRepository.findById(savedBurger.getId()).orElse(null);
        assertNotNull(retrievedBurger, "The retrieved burger should not be null");
        assertEquals("Cheeseburger", retrievedBurger.getItemName(), "Item name should match");

        // Ensure that collections were persisted (sauces and toppings)
        assertNotNull(retrievedBurger.getPatties(), "Sauces collection should be persisted");
        assertFalse(retrievedBurger.getPatties().isEmpty(), "There should be at least one patty");
        assertNotNull(retrievedBurger.getCheeses(), "Cheeses collection should be persisted");
        assertFalse(retrievedBurger.getCheeses().isEmpty(), "There should be at least one cheese");

    }

    @Test
    public void testSauceAndToppingConstraints() {
        Burger burger = new Burger();
        // Creating a list of Patties with more than 4 elements should trigger an error.
        List<Patty> tooManyPatties = new ArrayList<>();
        tooManyPatties.add(Patty.BEEF);
        tooManyPatties.add(Patty.WAGYU);
        tooManyPatties.add(Patty.CHICKEN);
        tooManyPatties.add(Patty.WAGYU);
        tooManyPatties.add(Patty.CHICKEN); // Fifth Patty

        Exception pattyException = assertThrows(IllegalArgumentException.class, () -> {
            burger.setPatties(tooManyPatties);
        });
        assertTrue(pattyException.getMessage().contains("Cannot have more than 4 patties"));

        // Similarly for cheeses, create a list with more than 4 elements.
        List<Cheese> tooManyCheeses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // Assuming you have a valid enum value for Topping, or you can reuse one value repeatedly if testing only the constraint
            tooManyCheeses.add(Cheese.GOUDA);
        }
        Exception cheesesException = assertThrows(IllegalArgumentException.class, () -> {
            burger.setCheeses(tooManyCheeses);
        });
        assertTrue(cheesesException.getMessage().contains("Cannot have more than 4 cheeses"));

        // Similarly for cheeses, create a list with more than 8 elements.
        List<Garnish> tooManyGarnishes = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            // Assuming you have a valid enum value for Topping, or you can reuse one value repeatedly if testing only the constraint
            tooManyGarnishes.add(Garnish.PICKLES);
        }
        Exception garnishesException = assertThrows(IllegalArgumentException.class, () -> {
            burger.setGarnishes(tooManyGarnishes);
        });
        assertTrue(garnishesException.getMessage().contains("Cannot have more than 8 garnishes"));


    }
}