package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.shape.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group();
        primaryStage.setTitle("Hello World");

        // Test elements
        Circle circle = new Circle(100, 100, 50);
        Button button = new Button("Animate!");

        root.getChildren().addAll(circle, button);

        // Test Animations
        Sprint sprint = new Sprint(circle);
        sprint.move(2.0, 200, 200).wait(1.0);

        sprint.setElement(button);
        sprint.move(5.0, 300, 0).sprint();


        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
