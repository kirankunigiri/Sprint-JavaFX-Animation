package com.kirankunigiri.Sprint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Kiran Kunigiri
 *
 * The main class for the Sprint example.
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Hello World");

        Button button = new Button("Animate!");

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        Controller.instance.setup();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
