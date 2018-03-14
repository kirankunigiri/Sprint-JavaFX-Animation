package com.kirankunigiri.Sprint;

import com.kirankunigiri.Sprint.Interpolators.*;
import javafx.animation.Interpolator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author Kiran Kunigiri
 *
 * An example controller class to show how you can animate a scene
 * using Sprint. In this scene, elements first animate onto the screen
 * by sliding in. Clicking the animate button will cause them
 * to re-animate in using different interpolators.
 */

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
        System.out.println("Initialized");
        instance = this;
    }

    public void setup() {
        System.out.println("Scene is displayed!");

        sprint = new Sprint(title);
        sprint.setInterpolator(new ElasticInterpolator());
        sprint.wait(0.5);
        sprint.slideFromLeft(2);
        sprint.setNode(subtitle).slideFromRight(2).wait(0.5).sprint();

        buttonSprint = new Sprint(button);
        buttonSprint.setInterpolator(new ElasticInterpolator());
        buttonSprint.wait(0.8).slideFromBottom(1.0).sprint();
        buttonSprint.setInterpolator(new BackInterpolator());

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
                Interpolator newInterpolator = getInterpolator();
                buttonSprint.setInterpolator(newInterpolator);
                buttonSprint.rotateTo(1.5, button.getRotate() + 360).sprint();
                sprint.setInterpolator(newInterpolator);
                sprint.setNode(title).slideFromLeft(1.5);
                sprint.setNode(subtitle).slideFromRight(1.5).sprint();
                sprint.setInterpolator(new BackInterpolator(EasingMode.EASE_IN));
            }
        }
    }

    /**
     * Gets the next interpolator from the 9 SprintInterpolators. Each time it is run,
     * the function will return the next interpolator from the list
     * @return The next SprintInterpolator
     */
    public Interpolator getInterpolator() {
        if (interpolatorIndex > 9) {
            interpolatorIndex = 1;
        }
        int num = interpolatorIndex;
        interpolatorIndex++;
        switch (num) {
            case 1: return new BackInterpolator();
            case 2: return new BounceInterpolator();
            case 3: return new CircularInterpolator();
            case 4: return new CubicInterpolator();
            case 5: return new ElasticInterpolator();
            case 6: return new ExponentialInterpolator();
            case 7: return new QuadraticInterpolator();
            case 8: return new QuinticInterpolator();
            case 9: return new SineInterpolator();
            default: return new BounceInterpolator();
        }
    }


}
