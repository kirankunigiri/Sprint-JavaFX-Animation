<p align="center">
<img src="https://github.com/kirankunigiri/Sprint-JavaFX-Animation/blob/master/Images/Logo.png" alt="Logo" height="150">
</p>

# Sprint
An animation framework for JavaFX animations that makes things incredibly easy.

## Installation
Just add the .jar from the release section of this page to your project to gain access to the Sprint and SprintInterpolator classes.

## Sprint Guide

With Sprint, you can chain animations together extremely easily.

First, create an instance of sprint by assigning it the node (element) you want to animate. Sprint can animate any object of the Node class, which includes Shapes and Control (UI) elements.

```
Sprint sprint = new Sprint(button);
```

### Basics

Next, start animating! Here's an example that animates a button by rotating it.
Specify the duration and the angle (degrees) in the parameters.
I've used 2 seconds and 360 degrees for a full spin.

At the end, be sure to run sprint(); to let sprint know that you've finished specifying the animation and to run it.

```
sprint.rotateTo(2, 360).sprint();
```

### From and To animations

You've probably noticed that in the previous animation, the method was called ```rotateTo(duration, angle)```. Are you thinking what I'm thinking? That's right! This means that there's also a ```rotateFrom(duration, angle)```. The from animations set the values to whatever you pass in, and animate them back to the values that were there before. This is useful in many different situations. A common use case is if you want something to appear from outside of the screen. You can use a from animation to set its position outside of the screen, so that it will automatically return to its existing position.

### Chaining

Next, let's get started with chaining animations together, and using some of the helper animation functions.
Let's say you wanted to animate a title and a subheading into the application from the sides. All we need to do is chain the 2 animations together.

Sprint also has a ```setNode(_node_);``` method so that you can change the object you are animating without having to create a new sprint! Let's test it out.

You could have done the 2 animations all in one line, but to be clear that we switched over to the subtitle Node, I separated it in the next line. Sprint also has several helper animation methods, one of which is ```slideFromRight(duration);```. This does just what it says - slides an object from the right side of the screen! There are also more that you can check out.

```
Sprint sprint = new Sprint(title);

sprint.slideFromLeft(1);
sprint.setNode(subtitle).slideFromRight(1).sprint();
```

### Interpolators (Ease Curves)

Interpolators tell sprint how the speed of an animation should happen, such as slow at first and then fast, if it should bounce, be elastic, go over the value requested, and more. JavaFX doesnt' really have that many to choose from besides ease in, ease out, and ease both. 

That's why Sprint also has a class called ```SprintInterpolators```, with many more fancy ones! With this, you can make an animation bounce, be elastic like a rubber band, and more! To change the interpolator Sprint is using, just use ```setIterpolator(_interpolator_)``` by using either the JavaFX default interpolators, or the new SprintInterpolators.
Credit to these interpolators go to Christian Schudt, who created them under the MIT License.

Here's an example. This will give the animation an elastic swing.

```
sprint.setInterpolator(SprintInterpolators.ELASTIC);
```

### Detecting Animation State

Many times, you will probably want to know when something has finished animating. Well, there's good news! Sprint also has a property called isAnimating, that, well, tells you if sprint is currently animating or not! You can detect changes using a ChangeListener, as shown below.

```
sprint.isAnimating.addListener( (v, oldValue, newValue) -> {
  System.out.println("Animation state is now: " + newValue);
});
```

## Contribute
Anyone can contribute to this project by adding more helper animation functions, adding more properties that you can animate with Swift, fixing any bugs, and more!

## License
MIT

## Logo
Credits to the logo go to Lorc from game-icons.net.
