---
title: API Reference

language_tabs: # must be one of https://git.io/vQNgJ
  - java

toc_footers:
  - <a href='https://kirankunigiri.com'>Developed by Kiran Kunigiri</a>

search: true
---

# Introduction

Welcome to the Sprint guide! Sprint is an animation framework for JavaFX that makes animations incredibly easy.

# Installation

Just add the .jar from the [releases page](https://github.com/kirankunigiri/Sprint-JavaFX-Animation/releases) of the GitHub repo to install. 

You can also run the .jar to look at a demo of some quick animations made with Sprint. Download the source from the [GitHub Repository](https://github.com/kirankunigiri/Sprint-JavaFX-Animation/) if you want to take a look at how the demo was made and learn by example.

In the following guide, you can follow along with the example code shown on the right pane.

You can check out the [javadocs](http://kirankunigiri.com/Sprint-JavaFX-Animation/) for a list of all methods and properties.

# Animation

## Setup Sprint

> Create an instance of the Sprint class and assign it a node to animate.

```java
Sprint sprint = new Sprint(button);
```

First, create an instance of sprint by assigning it the node (element) you want to animate. Sprint can animate any object of the Node class, which includes Shapes and Control (UI) elements.

## Animate

Next, animate the node using one of the following methods.

<!-- * `move` - Moves the node to specified coordinates
* `rotate` - Rotates the node by a number of degrees
* `scale` - Scales the node by a factor
* `fade` - Fades in or out to a new opacity value
* `fillColor` - Changes the fill color (shapes only)
* `strokeColor` - Changes the stroke/border color (shapes only) -->

Method | Description
--------- | ------- 
`move` | Moves the node to specified coordinates
`rotate` | Rotates the node by a number of degrees
`scale` | Scales the node by a factor
`fade` | Fades in or out to a new opacity value
`fillColor` | Changes the fill color (shapes only)
`strokeColor` | Changes the stroke/border color (shapes only)

Each method has a to and from version. For example, move has a `moveTo` and a `moveFrom` method.

**To Methods:** Animate a property to the new value given. Good for interaction animations.

**From Methods:** First set the property to the given values, and then animate the property back to its original value. Good for presentation animations, such as making elements fade in or move in when a window first opens, or while transitioning between scenes.

## Parameters
Each method comes has two parameters:

*  `duration` - length of the animation
*  `value` - the new value to animate to or from

> An example animation of rotating the button.

```java
sprint.rotateTo(2, 360).sprint();
```

**For example**, in the code to the right, we'll rotate by 360 degrees over a duration of 2 seconds.

# Chaining

The best feature of Sprint is that you can easily chain animations to make complex sequences in single lines of code. By default, all animations that you chain will occur in parallel at the same time. However, you can use `wait` to change it to a sequential transition by making Sprint wait for all previous animations to complete before continuing. Here are three new methods you'll want to use.

* `setNode(Node node)` - Switch to a different node to animate
* `wait(double duration)` - Causes Sprint to wait until all previous animations have been completed before continuing (you can use 0 if you don't want any pause)
* `sprint()` - Executes the animation

> Use animation chaining and the wait method to create a complex animation sequence.

```java
Sprint sprint = new Sprint(titleLabel);
sprint
  .moveFrom(duration, 0, -400)
  .setNode(captionLabel).moveFrom(duration, 0, -450).wait(0);
  .setNode(profileImage).moveFrom(duration, -400, 0)
  .setNode(headerImage).moveFrom(duration, -350, 0);
  .sprint();
```

  Here's a simple demo on the right. This first animates in the `titleLabel` and `captionLabel` from the top of the screen. Then, the `wait` method causes Sprint to wait until those nodes have finished animating, and then animates the `profileImage` and `headerImage` from the left of the screen.
  
  <aside class="notice">
Remember to call `sprint();` in the end to actually start the animation!
</aside>

# Interpolators

## Interpolator Types

Interpolators make your animations awesome and fancy.

They essentially provide mathematical functions to JavaFX to determine the speed vs. time graph for an animation. Rather than having an animation occur linearly, using an interpolator can make it stand out. 

JavaFX doesn't have many to choose from, so Sprint is also packed with lots of awesome Interpolator classes! With this, you can make an animation bounce, be elastic like a rubber band, and more. Credit to these interpolators go to Christian Schudt, who created them under the MIT License.

 `setInterpolator(Interpolator interpolator)` -  change the interpolator Sprint is using. Pass in either a normal JavaFX interpolator, or one of the ones included in Sprint.

## Easing Modes
 
 Easing modes allow you to select whether the interpolator effect occurs at the start, end, or both. To use it, just pass it in to the constructor of the interpolator you're using. By default (if nothing is passed in), `EasingMode.EASE_IN` will be used.
 
 > Assign an elastic interpolator to Sprint.

```java
// Uses the default easing mode of EASE_IN
sprint.setInterpolator(new ElasticInterpolator());
// Specify an easing mode
sprint.setInterpolator(new ElasticInterpolator(EasingMode.EASE_OUT));
```

 
 * `EasingMode.EASE_IN` - Animation effect occurs at the start
 * `EasingMode.EASE_OUT` - Animation effect occurs at the end
 * `EasingMode.EASE_BOTH` - Animation effect occurs at both start and end

Here's an example on the right. This will give the animation an elastic swing, and the second line shows how to use a different easing mode.

# Animation State


> Adds a listener to Sprint to run a method whenever an animation completes.

```java
sprint.isAnimating.addListener( (v, oldValue, newValue) -> {
  System.out.println("Animation state is now: " + newValue);
});
```

Many times, you will probably want to know when something has finished animating. Well, there's good news! Sprint also has a property called isAnimating, that, well, tells you if sprint is currently animating or not! You can detect changes using a ChangeListener, as shown below.