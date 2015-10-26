package de.anormalmedia.vividswinganimations.bounds;

import de.anormalmedia.vividswinganimations.api.Moveable;

/**
 * Extends location animation with linear interpolation between starting and
 * ending point
 *
 */
public class LinearInterpolationAnimation extends LocationAnimation {

    // private double startDistance;

    public LinearInterpolationAnimation(Moveable component, double targetX,
	    double targetY) {
	super(component, targetX, targetY);
	initialX = component.getLocationX();
	initialY = component.getLocationY();
	// this.startDistance = distance(component.getLocationX(),
	// component.getLocationY(), targetX, targetY);
    }

    @Override
    public void prepare() {
	prepared = true;
	fireAnimationStarted();
    }

    @Override
    public void animate(long timeProgress) {
	double velocityX = Math.abs(initialX - targetX) / getDuration();
	double velocityY = Math.abs(initialY - targetY) / getDuration();

	double nextX = component.getLocationX() + velocityX * timeProgress;
	double nextY = component.getLocationY() + velocityY * timeProgress;

	component.setLocationX(nextX);
	component.setLocationY(nextY);
    }

    private double interpolate(double s, double t, long timeProgress,
	    double initial) {
	double response = s + (t - initial)
		* (((double) timeProgress / getDuration()) * 100);
	return response;
    }

    @Override
    public double getTargetX() {
	return targetX;
    }

    @Override
    public double getTargetY() {
	return targetY;
    }

    /**
     * Get the distance from this point to another
     * 
     * @param targetY
     * @param targetX
     * @param e
     * @param d
     * 
     * @param other
     *            The other point we're measuring to
     * @return The distance to the other point
     */
    private double distance(double sx, double sy, double tx, double ty) {
	return Math.sqrt(distanceSquared(sx, sy, tx, ty));
    }

    /**
     * Get the distance from this point to another, squared. This can sometimes
     * be used in place of distance and avoids the additional sqrt.
     * 
     * @param ty
     * @param tx
     * @param sy
     * @param sx
     * 
     * @param other
     *            The other point we're measuring to
     * @param second
     * @return The distance to the other point squared
     */
    private double distanceSquared(double sx, double sy, double tx, double ty) {
	double dx = sx - tx;
	double dy = sy - ty;

	return dx * dx + (dy * dy);
    }

    // private DoublePoint interpolate(double sx, double sy, double tx, double
    // ty) {
    // double tx = sx
    // + (tx - element.getLocationX()) * fraction;
    // double ty = element.getLocationY()
    // + (position.getLongitude() - element.getLocationY()) * fraction;
    //
    // return new GeoPosition(tx, ty);
    // }
}
