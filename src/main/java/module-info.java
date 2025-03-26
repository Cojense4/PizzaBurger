module com.prog02.pizza_burger {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.prog02.pizza_burger to javafx.fxml;
    exports com.prog02.pizza_burger;
    exports com.prog02.pizza_burger.controllers;
    opens com.prog02.pizza_burger.controllers to javafx.fxml;
}