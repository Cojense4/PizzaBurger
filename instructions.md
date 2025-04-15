# Programming Assignment 3: Automated testing for the pizza and burger restaurant

## **Objective**: Practice creating automated test cases
This assignment builds on Programming Assignment 2 by adding JUnit test cases to it.

## **Directions**
Using the same repository as Programming Assignment 2, create a new branch of the repository to work in (prog03-testing).
Add the following test cases:

1. check that the total price of a [pizza](src/main/java/com/prog02/pizza_burger/model/pizza/Pizza.java)/[burger](src/main/java/com/prog02/pizza_burger/model/burger/Burger.java) is increased by the right amount when a [topping](src/main/java/com/prog02/pizza_burger/model/pizza/Topping.java)/[garnish](src/main/java/com/prog02/pizza_burger/model/burger/Garnish.java) is added.
2. check that the total price of a pizza/burgr matches the sum of its components.
3. check that the total price of the [cart](src/main/java/com/prog02/pizza_burger/model/user/CartManager.java) is increased by the right amount after assembling a pizza
4. check that the total price of the cart is increased by the right amount after assembling a burger
5. check that the total price of the cart is increased by the right amount after assembling two pizzas/two burgers.

Check [Burger components](src/main/java/com/prog02/pizza_burger/model/burger) for help on pricing
Check [Pizza components](src/main/java/com/prog02/pizza_burger/model/pizza) for help on pricing
*Test cases can be written as unit tests.*

Use proper formatting, identifier naming, and comments. We will follow the [Google Java style guide](https://google.github.io/styleguide/javaguide.html) as much as possible.

Formatting: indent blocks neatly. See [formatting section](https://google.github.io/styleguide/javaguide.html#s4-formatting) in the style guide.
Identifier naming: use "camel case". Capitalize the first letter of class names. See [naming section](https://google.github.io/styleguide/javaguide.html#s5-naming) in the style guide.
Comments: we will use Javadoc conventions. See [Javadoc section](https://google.github.io/styleguide/javaguide.html#s7-javadoc) in the style guide.

## Submission
For this assignment please plan to demo this in class.

## Grading
| Points    | Description                            |
|-----------|----------------------------------------|
| 5 points  | for proper use of Git branching        |
| 5 points  | for successful compilation             |
| 25 points | for successful implementation of tests |
| 10 points | for following the style guide          |
 