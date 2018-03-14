package com.kirankunigiri.Sprint;

import javafx.animation.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * @author Kiran Kunigiri
 * @version 1.0
 * Sprint is an animation framework for JavaFX that makes
 * animation incredibly easy.
 */

/** The main animator class */
public class Sprint {

    // Properties
    private Timeline timeline;
    private SequentialTransition sequentialTransition;
    private Interpolator interpolator = Interpolator.EASE_OUT;
    private Node node;
    /** The animation state of sprint */
    public BooleanProperty isAnimating;

    /**
     * Creates a sprint animator with a node. This node can be changed to any other node later using setNode()
     * @param node The element to animate
     */
    public Sprint(Node node) {
        this.timeline = new Timeline();
        this.sequentialTransition = new SequentialTransition();
        this.node = node;
        isAnimating = new SimpleBooleanProperty(this, "isAnimating", false);
    }

    /**
     * Animates the element to the new position at the specified coordinates.
     * @param duration Duration of the animation
     * @param x The new x coordinate to animate to
     * @param y The new y coordinate to animate to
     */
    public Sprint moveTo(double duration, int x, int y) {

        KeyValue keyValueX;
        KeyValue keyValueY;

        keyValueX = new KeyValue(node.translateXProperty(), x, interpolator);
        keyValueY = new KeyValue(node.translateYProperty(), y, interpolator);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element from the specified coordinates back to it's original position
     * @param duration Duration of the animation
     * @param x The new x coordinate to animate from
     * @param y The new y coordinate to animate from
     */
    public Sprint moveFrom(double duration, double x, double y) {

        Bounds boundsInScene = node.localToScene(node.getBoundsInLocal());

        KeyValue keyValueX;
        KeyValue keyValueY;

        keyValueX = new KeyValue(node.translateXProperty(), node.getTranslateX(), interpolator);
        keyValueY = new KeyValue(node.translateYProperty(), node.getTranslateY(), interpolator);

        node.setTranslateX(x);
        node.setTranslateY(y);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element to the new opacity specified
     * @param duration Duration of the animation
     * @param opacity The new opacity to animate to
     */
    public Sprint fadeTo(double duration, double opacity) {

        KeyValue keyValueX;

        keyValueX = new KeyValue(node.opacityProperty(), opacity, interpolator);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element from the specified opacity back to the original value
     * @param duration Duration of the animation
     * @param opacity The opacity to animate from
     */
    public Sprint fadeFrom(double duration, double opacity) {

        KeyValue keyValueX;
    
        keyValueX = new KeyValue(node.opacityProperty(), node.getOpacity(), interpolator);

        node.setOpacity(opacity);
        
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element's scale to the new value specified
     * @param duration Duration of the animation
     * @param x The scale width to animate to (The multiplier value to the original width)
     * @param y The scale height to animate to (The multiplier value to the original height)
     */
    public Sprint scaleTo(double duration, double x, double y) {

        KeyValue keyValueX;
        KeyValue keyValueY;

        keyValueX = new KeyValue(node.scaleXProperty(), x, interpolator);
        keyValueY = new KeyValue(node.scaleYProperty(), y, interpolator);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element's scale from the one specified back to the original
     * @param duration Duration of the animation
     * @param x The scale width to animate from (The multiplier value to the original width)
     * @param y The scale height to animate from (The multiplier value to the original height)
     */
    public Sprint scaleFrom(double duration, double x, double y) {

        KeyValue keyValueX;
        KeyValue keyValueY;

        keyValueX = new KeyValue(node.scaleXProperty(), node.getScaleX(), interpolator);
        keyValueY = new KeyValue(node.scaleYProperty(), node.getScaleY(), interpolator);

        node.setScaleX(x);
        node.setScaleY(y);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX, keyValueY);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element's rotation to the new value specified
     * @param duration Duration of the animation
     * @param angle The angle to rotate the element by around it's center
     */
    public Sprint rotateTo(double duration, double angle) {

        KeyValue keyValueX;

        keyValueX = new KeyValue(node.rotateProperty(), angle, interpolator);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element from the specified rotation back to the original value
     * @param duration Duration of the animation
     * @param angle The angle to rotate the element by around it's center
     */
    public Sprint rotateFrom(double duration, double angle) {

        KeyValue keyValueX;

        keyValueX = new KeyValue(node.rotateProperty(), node.getRotate(), interpolator);

        node.setRotate(angle);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element's color to the specified value. CAN ONLY BE APPLIED TO SHAPES.
     * @param duration Duration of the animation
     * @param color The color to animate to
     */
    public Sprint fillColorTo(double duration, Color color) {

        KeyValue keyValueX;

        if (node instanceof Shape) {
            Shape shape = (Shape) node;
            keyValueX = new KeyValue(shape.fillProperty(), color, interpolator);
        } else {
            return this;
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element's color from the specified value back to the original. CAN ONLY BE APPLIED TO SHAPES.
     * @param duration Duration of the animation
     * @param color The color to animate from
     */
    public Sprint fillColorFrom(double duration, Color color) {

        KeyValue keyValueX;

        if (node instanceof Shape) {
            Shape shape = (Shape) node;
            keyValueX = new KeyValue(shape.fillProperty(), shape.getFill(), interpolator);

            shape.setFill(color);
        } else {
            return this;
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element's stroke color to specified value. CAN ONLY BE APPLIED TO SHAPES.
     * @param duration Duration of the animation
     * @param color The color to animate to
     */
    public Sprint strokeColorTo(double duration, Color color) {

        KeyValue keyValueX;

        if (node instanceof Shape) {
            Shape shape = (Shape) node;
            keyValueX = new KeyValue(shape.strokeProperty(), color, interpolator);
        } else {
            return this;
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }

    /**
     * Animates the element's border color from the specified value back to the original. CAN ONLY BE APPLIED TO SHAPES.
     * @param duration Duration of the animation
     * @param color The color to animate from
     */
    public Sprint strokeColorFrom(double duration, Color color) {

        KeyValue keyValueX;

        if (node instanceof Shape) {
            Shape shape = (Shape) node;
            keyValueX = new KeyValue(shape.strokeProperty(), shape.getStroke(), interpolator);

            shape.setStroke(color);
        } else {
            return this;
        }

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        return this;
    }


    /**
     * Change the interpolator to a custom one
     * @param interpolator The new interpolator to use
     */
    public Sprint setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;

        return this;
    }

    /**
     * Get the current interpolator being used
     * @return interpolator
     */
    public Interpolator getInterpolator() {
        return this.interpolator;
    }

    /**
     * Play the animation
     */
    public void sprint() {
        sequentialTransition.getChildren().add(timeline);
        sequentialTransition.play();

        isAnimating.set(true);
        sequentialTransition.setOnFinished(event -> {
            isAnimating.set(false);
        });

        this.timeline = new Timeline();
        this.sequentialTransition = new SequentialTransition();
    }

    /**
     * Loops the animation. Use the value 0 to run the loop indefinitely.
     * Looping animations usually work best with the ease both interpolator.
     * @param count The number of times to run the animation. 0 for indefinite.
     */
    public void loop(int count) {
        sequentialTransition.getChildren().add(timeline);

        if (count == 0) {
            sequentialTransition.setCycleCount(SequentialTransition.INDEFINITE);
        } else {
            sequentialTransition.setCycleCount(count);
        }

        sequentialTransition.setAutoReverse(true);
        sequentialTransition.play();

        isAnimating.set(true);
        sequentialTransition.setOnFinished(event -> {
            isAnimating.set(false);
        });

        this.timeline = new Timeline();
        this.sequentialTransition = new SequentialTransition();
    }


    /**
     * Create a pause in the animation timeline, so that elements can animate at different times.
     * Normally, all animations are occur at the same time. Use wait() in order to move on to the next animation.
     * Use a time of 0.0 if you want there to be no gap, but rather just a transition to the next animation.
     * @param time The duration to pause the animation
     */
    public Sprint wait(double time) {

        sequentialTransition.getChildren().add(timeline);
        timeline = new Timeline();

        // Adds a fake animation to create a pause
        KeyValue keyValueX = new KeyValue(node.rotateProperty(), node.getRotate());
        Duration duration = Duration.seconds(time);

        KeyFrame keyFrame = new KeyFrame(duration, keyValueX);
        timeline.getKeyFrames().add(keyFrame);

        sequentialTransition.getChildren().add(timeline);
        timeline = new Timeline();

        return this;
    }

    /**
     * Change the element being animated.
     * @param node The new element to animate
     */
    public Sprint setNode(Node node) {
        this.node = node;
        return this;
    }

    /**
     * Get the node being animated
     * @return node
     */
    public Node getNode() {
        return this.node;
    }

    /**
     * Determine whether Sprint is currently animating or not
     * @return Animation state
     */
    public boolean isAnimating() {
        return this.isAnimating.get();
    }

    // Helper animation functions

    /**
     * Slides an element in from the right side of the screen to its original position.
     * @param duration The duration of the animation
     */
    public Sprint slideFromRight(double duration) {

        Bounds boundsInScene = node.localToScene(node.getBoundsInLocal());
        double dx = node.getScene().getWidth() - boundsInScene.getMaxX() + boundsInScene.getWidth();
        this.moveFrom(duration, dx, node.getTranslateY());
        return this;
    }

    /**
     * Slides an element in from the left side of the screen to its original position.
     * @param duration The duration of the animation
     */
    public Sprint slideFromLeft(double duration) {

        Bounds boundsInScene = node.localToScene(node.getBoundsInLocal());
        double dx = -boundsInScene.getMinX() - boundsInScene.getWidth();
        this.moveFrom(duration, dx, node.getTranslateY());

        return this;
    }

    /**
     * Slides an element in from the top of the screen to its original position.
     * @param duration The duration of the animation
     */
    public Sprint slideFromTop(double duration) {

        Bounds boundsInScene = node.localToScene(node.getBoundsInLocal());
        double dy = -boundsInScene.getMinY() - boundsInScene.getHeight();
        this.moveFrom(duration, node.getTranslateX(), dy);

        return this;
    }

    /**
     * Slides an element in from the bottom of the screen to its original position.
     * @param duration The duration of the animation
     */
    public Sprint slideFromBottom(double duration) {

        Bounds boundsInScene = node.localToScene(node.getBoundsInLocal());
        double dy = node.getScene().getHeight() - boundsInScene.getMaxY() + boundsInScene.getHeight();
        this.moveFrom(duration, node.getTranslateX(), dy);

        return this;
    }

}































