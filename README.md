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
- **src/test**: Contains unit tests for the pizza and burger components.

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

If you need more details about the design or implementation of specific features such as price calculations, component sorting, or FXML controller interactions, feel free to ask!

Happy Coding!