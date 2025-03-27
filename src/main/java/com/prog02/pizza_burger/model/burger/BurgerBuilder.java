package com.prog02.pizza_burger.model.burger;

import java.util.ArrayList;
import java.util.Scanner;

public class BurgerBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Burger> burgers = new ArrayList<>();

        System.out.print("Enter the number of burgers you want to build: ");
        int burgerCount = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        for (int i = 0; i < burgerCount; i++) {
            System.out.println("\n--- Building Burger " + (i + 1) + " ---");

            // Prompt for bun selection
            System.out.println("Select a bun:");
            for (Buns bun : Buns.values()) {
                System.out.println((bun.ordinal() + 1) + ". " + bun.getName());
            }
            int bunChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            Buns selectedBun = Buns.values()[bunChoice - 1];

            // Prompt if the bun should be toasted
            System.out.print("Would you like the bun toasted? (y/n): ");
            String toastedInput = scanner.nextLine();
            boolean isToasted = toastedInput.trim().toLowerCase().startsWith("y");
            // Since the Buns enum is immutable, we simulate the toasted option
            // by noting it here. In a more complete design, you might create a wrapper or separate class.
            String bunDisplay = selectedBun.toNiceString();
            if (isToasted) {
                bunDisplay += " (Toasted)";
            }

            // Prompt for patties selection
            System.out.println("Select patties (enter numbers separated by spaces):");
            for (Patties patty : Patties.values()) {
                System.out.println((patty.ordinal() + 1) + ". " + patty.getName());
            }
            String pattiesInput = scanner.nextLine();
            String[] pattiesChoices = pattiesInput.trim().split("\\s+");
            ArrayList<Patties> selectedPatties = new ArrayList<>();
            for (String choice : pattiesChoices) {
                try {
                    int index = Integer.parseInt(choice) - 1;
                    if (index >= 0 && index < Patties.values().length) {
                        selectedPatties.add(Patties.values()[index]);
                    } else {
                        System.out.println("Invalid patty number: " + (index + 1));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for patty: " + choice);
                }
            }

            // Prompt for cheeses selection
            System.out.println("Select cheeses (enter numbers separated by spaces):");
            for (Cheeses cheese : Cheeses.values()) {
                System.out.println((cheese.ordinal() + 1) + ". " + cheese.toNiceString());
            }
            String cheesesInput = scanner.nextLine();
            String[] cheesesChoices = cheesesInput.trim().split("\\s+");
            ArrayList<Cheeses> selectedCheeses = new ArrayList<>();
            // For each cheese, prompt if it should be smoked and/or aged.
            for (String choice : cheesesChoices) {
                try {
                    int index = Integer.parseInt(choice) - 1;
                    if (index >= 0 && index < Cheeses.values().length) {
                        Cheeses baseCheese = Cheeses.values()[index];
                        System.out.print("Should the cheese '" + baseCheese.getName() + "' be smoked? (y/n): ");
                        String smokedInput = scanner.nextLine();
                        boolean isSmoked = smokedInput.trim().toLowerCase().startsWith("y");
                        System.out.print("Should the cheese '" + baseCheese.getName() + "' be aged? (y/n): ");
                        String agedInput = scanner.nextLine();
                        boolean isAged = agedInput.trim().toLowerCase().startsWith("y");
                        // Note: Since Cheeses enum values are immutable, we cannot modify the instance.
                        // In a full implementation, you might create a new Cheese object based on baseCheese and these options.
                        // For demonstration, we'll simply add the base cheese and note modifications in the receipt.
                        selectedCheeses.add(baseCheese);
                        // Optionally, you can display the chosen modifications later.
                        System.out.println("You chose: " + baseCheese.getName() +
                                (isSmoked ? " Smoked" : "") + (isAged ? " Aged" : ""));
                    } else {
                        System.out.println("Invalid cheese number: " + (index + 1));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for cheese: " + choice);
                }
            }

            // Prompt for garnishes selection
            System.out.println("Select garnishes (enter numbers separated by spaces):");
            for (Garnishes garnish : Garnishes.values()) {
                System.out.println((garnish.ordinal() + 1) + ". " + garnish.toNiceString());
            }
            String garnishesInput = scanner.nextLine();
            String[] garnishesChoices = garnishesInput.trim().split("\\s+");
            ArrayList<Garnishes> selectedGarnishes = new ArrayList<>();
            for (String choice : garnishesChoices) {
                try {
                    int index = Integer.parseInt(choice) - 1;
                    if (index >= 0 && index < Garnishes.values().length) {
                        selectedGarnishes.add(Garnishes.values()[index]);
                    } else {
                        System.out.println("Invalid garnish number: " + (index + 1));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for garnish: " + choice);
                }
            }

            // Create the Burger object.
            Burger burger = new Burger(selectedBun, selectedPatties, selectedCheeses, selectedGarnishes);

            // Display a note about modifications
            System.out.println("\nBurger " + (i + 1) + " created:");
            System.out.println("Bun: " + bunDisplay);
            System.out.println("Cheeses: (Modifications noted above if applicable)");
            burger.display();
        }

        scanner.close();
    }
}