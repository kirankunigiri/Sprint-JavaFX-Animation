package sample;

import javafx.animation.Interpolator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    Sprint sprint;
    boolean titleIsAnimating = true;
    Sprint buttonSprint;
    boolean buttonIsAnimating = false;
    public static Controller instance;
    int interpolatorIndex = 1;

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

        sprint = new Sprint(title);
        sprint.setInterpolator(SprintInterpolators.ELASTIC);
        sprint.wait(0.5);
        sprint.slideFromLeft(2);
        sprint.setNode(subtitle).slideFromRight(2).wait(0.5).sprint();

        buttonSprint = new Sprint(button);
        buttonSprint.setInterpolator(SprintInterpolators.EXPONENTIAL);
        buttonSprint.wait(0.8).slideFromBottom(1.0).sprint();
        buttonSprint.setInterpolator(SprintInterpolators.BACK);

        sprint.isAnimating.addListener( (v, oldValue, newValue) -> {
            System.out.println("Animation state is now: " + newValue);
            titleIsAnimating = newValue;
        });

        buttonSprint.isAnimating.addListener( (v, oldValue, newValue) -> {
            System.out.println("Animation state is now: " + newValue);
            buttonIsAnimating = newValue;
        });
    }

    public void buttonClicked() {
        if (!buttonIsAnimating) {
            if (!titleIsAnimating) {
                buttonSprint.rotateTo(1, button.getRotate() + 360).sprint();
                sprint.setInterpolator(getInterpolator());
                sprint.setNode(title).slideFromLeft(1.5).sprint();
                sprint.setNode(subtitle).slideFromRight(1.5).sprint();
            }
        }
    }

    public Interpolator getInterpolator() {
        if (interpolatorIndex > 9) {
            interpolatorIndex = 1;
        }
        int num = interpolatorIndex;
        interpolatorIndex++;
        switch (num) {
            case 1: return SprintInterpolators.BACK;
            case 2: return SprintInterpolators.BOUNCE;
            case 3: return SprintInterpolators.CIRCULAR;
            case 4: return SprintInterpolators.CUBIC;
            case 5: return SprintInterpolators.ELASTIC;
            case 6: return SprintInterpolators.EXPONENTIAL;
            case 7: return SprintInterpolators.QUADRATIC;
            case 8: return SprintInterpolators.QUINTIC;
            case 9: return SprintInterpolators.SINE;
            default: return SprintInterpolators.BOUNCE;
        }
    }


}
