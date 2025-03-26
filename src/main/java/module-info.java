module com.prog02.burger {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.prog02.burger to javafx.fxml;
    exports com.prog02.burger;
}