package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        Group root = new Group();
        primaryStage.setTitle("Hello World");

        // Test elements
//        Circle circle = new Circle(100, 100, 50);
//        Button button = new Button("Animate!");
//
//        root.getChildren().addAll(circle, button);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        Controller.instance.setup();

        // Test Animations
//        Sprint sprint = new Sprint(button);
//        sprint.setInterpolator(Interpolator.EASE_BOTH);

//        sprint.moveTo(2.0, 200, 200).wait(0.0);
//
//        sprint.setElement(button);
//        sprint.moveFrom(2.0, 300, 0).sprint();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
