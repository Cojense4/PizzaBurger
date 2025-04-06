# Pizza Burger Ordering System

This project is a GUI-based pizza and burger ordering system built with JavaFX and Maven. Users can customize their orders through a graphical interface and view their final receipt. The application supports ordering both pizzas and burgers with various customizations.

## Project Structure

- **src/main/java**: Contains the Java source code.
  - Main application entry point: [`com.prog02.pizza_burger.App`](src/main/java/com/prog02/pizza_burger/App.java)
  - Controller classes:
    - [`MainController`](src/main/java/com/prog02/pizza_burger/MainController.java)
    - [`PizzaBuilderController`](src/main/java/com/prog02/pizza_burger/PizzaBuilderController.java)
    - [`BurgerBuilderController`](src/main/java/com/prog02/pizza_burger/BurgerBuilderController.java)
    - [`ShopCartController`](src/main/java/com/prog02/pizza_burger/ShopCartController.java)
    - [`CompletedController`](src/main/java/com/prog02/pizza_burger/CompletedController.java)
  - Model packages:
    - Pizza-related: [`com.prog02.pizza_burger.model.pizza`](src/main/java/com/prog02/pizza_burger/model/pizza)
    - Burger-related: [`com.prog02.pizza_burger.model.burger`](src/main/java/com/prog02/pizza_burger/model/burger)
    - Common interfaces and classes: [`com.prog02.pizza_burger.model.common`](src/main/java/com/prog02/pizza_burger/model/common)
    - User and cart management: [`com.prog02.pizza_burger.model.user`](src/main/java/com/prog02/pizza_burger/model/user)
- **src/main/resources**: Contains the FXML files and other resources.
  - Main views: [`Main.fxml`](src/main/resources/com/prog02/pizza_burger/Main.fxml), [`PizzaBuilder.fxml`](src/main/resources/com/prog02/pizza_burger/PizzaBuilder.fxml), [`BurgerBuilder.fxml`](src/main/resources/com/prog02/pizza_burger/BurgerBuilder.fxml)
  - Other views: [`Completed.fxml`](src/main/resources/com/prog02/pizza_burger/Completed.fxml)
- **src/test**: Contains unit tests for the pizza and burger components.

## Changes from original code (Ex 07)
1. Added fromItemName() method to generate an object based on the class given (defaults to first enum val).

NEW MenuItem, AbstractMenuItem, Priceable, and classes
MenuItem.java:
```java
package com.prog02.pizza_burger.model.common;
    
public interface MenuItem {
    double getPrice();
    String getName();
    default String display() { return getName() + " (" + String.format("%.2f",getPrice()) + ")"; }
    static <T extends Enum<T> & MenuItem> T fromItemName(Class<T> enumType, String itemName) {
        for (T item : enumType.getEnumConstants()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        // Returns the first enum constant as the default.
        return enumType.getEnumConstants()[0];
    }
}
```

NEW PriceableWrapper object for sorting the components as they had more fields than a Priceable object  
PriceableWrapper.java:
```java
package com.prog02.pizza_burger.model.common;
/**
 * A wrapper class that adapts a MenuItem to Priceable.
 */
public class PriceableWrapper extends Priceable {
    private final MenuItem item;

    public PriceableWrapper(MenuItem item) {
        // Call the Priceable constructor using the item's price and name.
        super(item.getPrice(), item.getName());
        this.item = item;
    }
}
```

NEW Pizza.java file
## Technologies Used

- **JavaFX** for building the user interface.
- **Maven** for dependency management and build automation.
- **JUnit 5** for unit testing.
- **JFoenix** for Material Design styled controls.

## Building and Running

1. **Build the Project:**  
   Use Maven to compile the project:
   ```sh
   mvn clean compile
   ```

2. **Run Unit Tests:**  
   Execute the tests with:
   ```sh
   mvn test
   ```

3. **Run the Application:**  
   Use the JavaFX Maven plugin:
   ```sh
   mvn clean javafx:run
   ```

## Usage

- Launch the application to see the main menu.
- **Make Pizza:** Click the "Make Pizza" button to customize your pizza.
- **Make Burger:** Click the "Make Burger" button to customize your burger.
- Add items to the cart and check out to see the final receipt.

## Configuration

- **Maven Configuration:**  
  The [pom.xml](pom.xml) file configures the project dependencies and the JavaFX Maven plugin.


## Additional Context

This project is for Programming Assignment 2: GUI for pizza and burger restaurant
If you need more details about the design or implementation of specific features such as price calculations, component sorting, or FXML controller interactions, feel free to ask!

Happy Coding!