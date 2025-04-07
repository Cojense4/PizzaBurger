package com.prog02.pizza_burger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static String fxmlFilePath = "Main.fxml"; // default FXML file

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlFilePath));
        Parent root = fxmlLoader.load();
        scene = new Scene(root, 1200, 700);

        stage.setTitle("Pizza Burger!");
        stage.setScene(scene);
        stage.show();
    }

    // This method allows external parts of your application to switch the FXML view.
    public static void setRoot(String newFxmlFilePath) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(newFxmlFilePath));
        Parent newRoot = loader.load();
        scene.setRoot(newRoot);
    }

    // Optionally, you can modify the main method to accept a command-line parameter
    // that sets the initial FXML file.
    public static void main(String[] args) {
        if (args.length > 0) {
            fxmlFilePath = args[0];
        }
        launch(args);
    }
}