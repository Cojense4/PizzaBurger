module com.prog02.pizza_burger {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.prog02.pizza_burger to javafx.fxml;
    exports com.prog02.pizza_burger;
}