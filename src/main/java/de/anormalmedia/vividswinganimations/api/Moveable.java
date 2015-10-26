package de.anormalmedia.vividswinganimations.api;

/**
 * A moveable object is a gui component (Swing or not) that can be animated
 *
 */
public interface Moveable {

    public double getLocationX();

    public void setLocationX(double x);

    public double getLocationY();

    public void setLocationY(double y);

}
