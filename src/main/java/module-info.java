module com.prog02.pizza_burger {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    exports com.prog02.pizza_burger;
    opens com.prog02.pizza_burger to javafx.fxml;
}