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
  - Other views: [`ShopCart.fxml`](src/main/resources/com/prog02/pizza_burger/ShopCart.fxml), [`Completed.fxml`](src/main/resources/com/prog02/pizza_burger/Completed.fxml)
- **[`src/test/PizzaTest`](src/test/com/prog02/pizza_burger/model/PizzaTest.java)& [`src/test/BurgerTest`](src/test/com/prog02/pizza_burger/model/BurgerTest.java)**: Contains unit tests for the pizza and burger components.

## Changes from original code (Ex 07)
* [`MenuItem`](src/main/java/com/prog02/pizza_burger/model/common/MenuItem.java) interface has new methods to make creating an instantiation of a class easier
* All item classes have been consolidated down to enum 'templates' (Ex. ThickCrust, ThinCrust, etc. --> one enum file)
  * Pizza Components:
    - **[`Crust`](src/main/java/com/prog02/pizza_burger/model/pizza/Crust.java)**: Traditional, Thin, Cauliflower, Thick
    - **[`Sauce`](src/main/java/com/prog02/pizza_burger/model/pizza/Sauce.java)**: Alfredo, Traditional, Meat, Garlic
    - **[`Topping`](src/main/java/com/prog02/pizza_burger/model/pizza/Topping.java)**: Cheeses, Meats, & Veggies
      - The toppings are all in the same enum but have four values to each type
  * Burger Components:
    - **[`Bun`](src/main/java/com/prog02/pizza_burger/model/burger/Bun.java)**: Brioche, Potato, Sesame, Sourdough
    - **[`Cheese`](src/main/java/com/prog02/pizza_burger/model/burger/Cheese.java)**: American, Cheddar, Gouda, Pepper_Jack
    - **[`Garnish`](src/main/java/com/prog02/pizza_burger/model/burger/Garnish.java)**: Veg and Non-Veg
      - isCooked is a variable that helps to determine if the topping has been cooked ([Food Handlers Permit](https://foodhandlers.unl.edu/en/login))
    - **[`Patty`](src/main/java/com/prog02/pizza_burger/model/burger/Patty.java)**: Beef, Wagyu, Chicken, Salmon
* Full classes ([`Pizza`](src/main/java/com/prog02/pizza_burger/model/pizza/Pizza.java) and [`Burger`](src/main/java/com/prog02/pizza_burger/model/burger/Burger.java)) also have their own templates (PizzaTemplate & BurgerTemplate)
   - **[`PizzaTemplate`](src/main/java/com/prog02/pizza_burger/model/pizza/PizzaTemplate.java)**: Cheese, Pepperoni, Supreme, Veggie Lover
   - **[`BurgerTemplate`](src/main/java/com/prog02/pizza_burger/model/burger/BurgerTemplate.java)**: Cheeseburger, Bacon Cheeseburger, Double Double, King Burger
* Managing the cart contents is done through [`CartManager`](src/main/java/com/prog02/pizza_burger/model/user/CartManager.java)
* Locally hosting is enabled by [JPro Academic License](https://www.jpro.one/)

## Technologies Used
- **Maven** for dependency management and build automation.
- **JavaFX** for building the user interface.
- **JFoenix** for Material Design styled controls.
- **JUnit 5** for unit testing.
- **JPro** for hosting JavaFX on the web

## Building and Running

1. **Build the Project:**  
   Use Maven to compile the project:
   ```shell
   mvn clean
   ```

2. **Run Unit Tests:**  
   Execute the unit tests with:
   ```shell
   mvn test
   ```

3. **Run the Application (Via javafx):**  
   * Use the JavaFX Maven plugin:
      ```shell
      mvn clean javafx:run
      ```
    Or
   * Use the JPro Maven plugin:
       ```shell
       mvn jpro:run
       ```
## Usage
- Start the application to see the main menu.
- **Make Pizza:** Click the "Make Pizza" button to customize your pizza.
- **Make Burger:** Click the "Make Burger" button to customize your burger.
- Add items to the cart and check out to see the final receipt.

## Configuration
- **Maven Configuration:**  
  The [`pom.xml`](pom.xml) file configures the project dependencies.


## Additional Context

This project is for Programming Assignment 2: GUI for pizza and burger restaurant
If you need more details about the design or implementation of specific features, please ask!