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
     * @param shape The element to animate
     */
    public Sprint(Shape shape) {
        this.timeline = new Timeline();
        this.sequentialTransition = new SequentialTransition();
        this.shape = shape;
    }

    /**
     * Creates a sprint animator with a UI Element (control object). This element can be changed to any other element later using setElement()
     * @param control The element to animate
     */
    public Sprint(Control control) {
        this.timeline = new Timeline();
        this.sequentialTransition = new SequentialTransition();
        this.control = control;
    }

    /**
     * Animates the element to a the new position given the coordinates.
     * @param duration Duration of the animation
     * @param x The new x coordinate to animate to
     * @param y The new y coordinate to animate to
     */
    public Sprint moveTo(double duration, int x, int y) {

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
     * Animates the element to a the new position given the coordinates.
     * @param duration Duration of the animation
     * @param x The new x coordinate to animate to
     * @param y The new y coordinate to animate to
     */
    public Sprint moveFrom(double duration, int x, int y) {

        KeyValue keyValueX;
        KeyValue keyValueY;

        if (shape != null) {
            keyValueX = new KeyValue(shape.translateXProperty(), shape.getTranslateX(), Interpolator.EASE_BOTH);
            keyValueY = new KeyValue(shape.translateYProperty(), shape.getTranslateY(), Interpolator.EASE_BOTH);

            shape.setTranslateX(x);
            shape.setTranslateY(y);
        } else {
            keyValueX = new KeyValue(control.translateXProperty(), control.getTranslateX(), Interpolator.EASE_BOTH);
            keyValueY = new KeyValue(control.translateYProperty(), control.getTranslateY(), Interpolator.EASE_BOTH);

            control.setTranslateX(x);
            control.setTranslateY(y);
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element to the new opacity given
     * @param duration Duration of the animation
     * @param opacity The new opacity to animate to
     */
    public Sprint fadeTo(double duration, double opacity) {

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

    /**
     * Animates the element to the new opacity given
     * @param duration Duration of the animation
     * @param opacity The new opacity to animate to
     */
    public Sprint fadeFrom(double duration, double opacity) {

        KeyValue keyValueX;

        if (shape != null) {
            keyValueX = new KeyValue(shape.opacityProperty(), shape.getOpacity(), Interpolator.EASE_BOTH);

            shape.setOpacity(opacity);
        } else {
            keyValueX = new KeyValue(control.opacityProperty(), control.getOpacity(), Interpolator.EASE_BOTH);

            control.setOpacity(opacity);
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element's scale to the new one given
     * @param duration Duration of the animation
     * @param x The scale width to animate (A ratio based on the current width)
     * @param y The scale height to animate (A ratio based on the current height)
     */
    public Sprint scaleTo(double duration, double x, double y) {

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

    public Sprint scaleFrom(double duration, double x, double y) {

        KeyValue keyValueX;
        KeyValue keyValueY;

        if (shape != null) {
            keyValueX = new KeyValue(shape.scaleXProperty(), shape.getScaleX(), Interpolator.EASE_BOTH);
            keyValueY = new KeyValue(shape.scaleYProperty(), shape.getScaleY(), Interpolator.EASE_BOTH);

            shape.setScaleX(x);
            shape.setScaleY(y);
        } else {
            keyValueX = new KeyValue(control.scaleXProperty(), control.getScaleX(), Interpolator.EASE_BOTH);
            keyValueY = new KeyValue(control.scaleYProperty(), control.getScaleY(), Interpolator.EASE_BOTH);

            control.setScaleX(x);
            control.setScaleY(y);
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element's rotation to the new one given
     * @param duration Duration of the animation
     * @param angle The angle to rotate the element by. It's axis is the center of the element.
     */
    public Sprint rotateTo(double duration, double angle) {

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

    /**
     * Animates the element's rotation to the new one given
     * @param duration Duration of the animation
     * @param angle The angle to rotate the element by. It's axis is the center of the element.
     */
    public Sprint rotateFrom(double duration, double angle) {

        KeyValue keyValueX;

        if (shape != null) {
            keyValueX = new KeyValue(shape.rotateProperty(), shape.getRotate(), Interpolator.EASE_BOTH);

            shape.setRotate(angle);
        } else {
            keyValueX = new KeyValue(control.rotateProperty(), control.getRotate(), Interpolator.EASE_BOTH);

            control.setRotate(angle);
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Play the animation
     */
    public void sprint() {
        sequentialTransition.getChildren().add(timeline);
        sequentialTransition.play();

        this.timeline = null;
        this.sequentialTransition = null;
    }

    /**
     * Create a pause in the animation timeline, so that elements can animate at different times.
     * Normally, all animations are occurring at the same time. Use wait() in order to move on to the next animation.
     * Use a time of 0.0 if you want there to be no gap, but rather just a transition to the next animation.=
     * @param time
     * @return
     */
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

    /**
     * Change the element being animated.
     * @param element The new element to animate
     */
    public Sprint setElement(Shape element) {

        this.control = null;
        this.shape = element;

        return this;
    }

    /**
     * Change the element being animated
     * @param element The new element to animate
     */
    public Sprint setElement(Control element) {

        this.shape = null;
        this.control = element;

        return this;
    }

}
