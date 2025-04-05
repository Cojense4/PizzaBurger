module pizza_burger {
    requires javafx.controls;
    requires javafx.fxml;
    // If you're using JFoenix, include it as well:
    requires com.jfoenix;
    requires java.sql;

    exports com.prog02.pizza_burger;
    opens com.prog02.pizza_burger;
}