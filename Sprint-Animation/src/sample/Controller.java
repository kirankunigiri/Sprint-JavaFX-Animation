package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    Sprint sprint;
    public static Controller instance;

    @FXML
    Button button;
    @FXML
    Label title;
    @FXML
    Label subtitle;

    public void initialize() {
        instance = this;
    }

    public void setup() {
        System.out.println("Scene is displayed!");

//        Sprint sprint1 = new Sprint(title);
//        Sprint sprint2 = new Sprint(subtitle);
//        sprint1.wait(0.4).slideFromLeft(0.6).sprint();
//        sprint2.wait(0.6).slideFromRight(0.6).sprint();

        sprint = new Sprint(title);
        sprint.setInterpolator(SprintInterpolators.ELASTIC);
        sprint.wait(0.5);
        sprint.slideFromLeft(2);
        sprint.setNode(subtitle).slideFromRight(2).wait(0.5);
        sprint.setNode(button).slideFromBottom(2).sprint();
    }

    public void buttonClicked() {
        sprint.rotateTo(3, button.getRotate() + 360).sprint();
    }

}
