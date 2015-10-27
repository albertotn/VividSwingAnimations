# VividSwingAnimations

A simple and powerful java swing animation framework

## Features

This branch differs from [master branch](https://github.com/anormal81/VividSwingAnimations) for following features:

* build support with maven
* add [Moveable](src/main/java/de/anormalmedia/vividswinganimations/api/Moveable.java) interface: not only Swing components can be animated

## Roadmap

I don't plan to release ofter, but I plan to keep consistent with master release

## HelloWorld example

```java
	// create an animator
	SequentialAnimationRunner defaultAnimator = new SequentialAnimationRunner();
	// build an animation and set destination
	LocationAnimation locationAnimation = new LocationAnimation(element, btnTestButton.getLocationX() + 100,element.getLocationY());
	// add a listener to get some events
	locationAnimation.addAnimationListener(new AnimationAdapter() {

	    @Override
	    public void animationStarted() {
		   System.out.println("Animation started");
	    }

	    @Override
	    public void animationUpdated() {
		   System.out.println("Animation updated");
	    }

	    @Override
	    public void animationFinished() {
		   System.out.println("Animation finished");
	    }

	});
    // add animation to animator
	defaultAnimator.addAnimation(locationAnimation);
    // run animator
	defaultAnimator.start();
```

## How to build

Install maven, clone repository and then use: maven clean install

