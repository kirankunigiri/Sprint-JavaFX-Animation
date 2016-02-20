package sample;

import javafx.animation.*;
import javafx.scene.control.Control;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * @author Kiran Kunigiri
 */

public class Sprint {

    Timeline timeline;
    SequentialTransition sequentialTransition;
    Shape shape;
    Control control;

    /**
     * Creates a sprint animator with a shape. This element can be changed to any other element later using setElement()
     * @param shape
     */
    public Sprint(Shape shape) {
        this.timeline = new Timeline();
        this.sequentialTransition = new SequentialTransition();
        this.shape = shape;
    }

    /**
     * Creates a sprint animator with a UI Element (control object). This element can be changed to any other element later using setElement()
     * @param control
     */
    public Sprint(Control control) {
        this.timeline = new Timeline();
        this.sequentialTransition = new SequentialTransition();
        this.control = control;
    }

    public Sprint moveFromUI(double time, int x, int y) {
        System.out.println("I am moving to " + control.getTranslateX() + ", " + control.getTranslateY());

        KeyValue keyValueX = new KeyValue(control.translateXProperty(), control.getTranslateX(), Interpolator.EASE_BOTH);
        KeyValue keyValueY = new KeyValue(control.translateYProperty(), control.getTranslateY(), Interpolator.EASE_BOTH);
        Duration duration = Duration.seconds(time);

        control.setTranslateX(x);
        control.setTranslateY(y);

        KeyFrame keyFrame = new KeyFrame(duration, keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element to a the new position given the coordinates.
     * @param duration Duration of the animation
     * @param x The new x coordinate to animate to
     * @param y The new y coordinate to animate to
     * @return An instance of the sprint animator to chain animations
     */
    public Sprint move(double duration, int x, int y) {

        KeyValue keyValueX;
        KeyValue keyValueY;

        if (shape != null) {
            keyValueX = new KeyValue(shape.translateXProperty(), x, Interpolator.EASE_BOTH);
            keyValueY = new KeyValue(shape.translateYProperty(), y, Interpolator.EASE_BOTH);
        } else {
            keyValueX = new KeyValue(control.translateXProperty(), x, Interpolator.EASE_BOTH);
            keyValueY = new KeyValue(control.translateYProperty(), y, Interpolator.EASE_BOTH);
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element to the new opacity given
     * @param duration Duration of the animation
     * @param opacity The new opacity to animate to
     * @return
     */
    public Sprint fade(double duration, double opacity) {

        KeyValue keyValueX;

        if (shape != null) {
            keyValueX = new KeyValue(shape.opacityProperty(), opacity, Interpolator.EASE_BOTH);
        } else {
            keyValueX = new KeyValue(control.opacityProperty(), opacity, Interpolator.EASE_BOTH);
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    public Sprint scale(double duration, double x, double y) {

        KeyValue keyValueX;
        KeyValue keyValueY;

        if (shape != null) {
            keyValueX = new KeyValue(shape.scaleXProperty(), x, Interpolator.EASE_BOTH);
            keyValueY = new KeyValue(shape.scaleYProperty(), y, Interpolator.EASE_BOTH);
        } else {
            keyValueX = new KeyValue(control.scaleXProperty(), x, Interpolator.EASE_BOTH);
            keyValueY = new KeyValue(control.scaleYProperty(), y, Interpolator.EASE_BOTH);
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    public Sprint rotate(double duration, double angle) {

        KeyValue keyValueX;

        if (shape != null) {
            keyValueX = new KeyValue(shape.rotateProperty(), angle, Interpolator.EASE_BOTH);
        } else {
            keyValueX = new KeyValue(control.rotateProperty(), angle, Interpolator.EASE_BOTH);
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    public void sprint() {
        sequentialTransition.getChildren().add(timeline);
        sequentialTransition.play();

        this.timeline = null;
        this.sequentialTransition = null;
    }

    public Sprint wait(double time) {

        sequentialTransition.getChildren().add(timeline);
        timeline = new Timeline();

        // Adds a fake animation to create a pause
        KeyValue keyValueX = new KeyValue(shape.fillProperty(), shape.getFill());
        Duration duration = Duration.millis(time);

        KeyFrame keyFrame = new KeyFrame(duration, keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        sequentialTransition.getChildren().add(timeline);
        timeline = new Timeline();

        System.out.println(timeline);

        return this;
    }

    public Sprint setElement(Shape element) {

        this.control = null;
        this.shape = element;

        return this;
    }

    public Sprint setElement(Control element) {

        this.shape = null;
        this.control = element;

        return this;
    }

}
