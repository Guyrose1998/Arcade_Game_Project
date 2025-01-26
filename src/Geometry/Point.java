// Guy Rosenthal
package Geometry;

import java.util.Random;

/**
 * ArcadeGame - geometryPrimitives.Point class.
 *
 * @author Guy Rozenthal 
 */
public class Point {
    /**
     * The constant SQUARE.
     */
// Finals
    static final double POW_OF_TWO = 2.0;
    /**
     * The Epsilon.
     */
    public static final double EPSILON = 0.0001;
    // Fields
    // x and y values of the point
    private double x;
    private double y;

    // constructor

    /**
     * a geometryPrimitives.Point constructor.
     *
     * @param x the x value of the point
     * @param y the y value of the point
     */
    public Point(double x, double y) {
        // the x value of the point
        this.x = x;
        // the x value of the point
        this.y = y;
    }

    /**
     * distance method return the distance between two points.
     *
     * @param other the other point with which we want to check the distance
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        /*
         * the distance between two points (x1,y1) and (x2,y2) is
         * the square root of: ((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2))
         */
        return Math.sqrt(Math.pow(this.x - other.x, POW_OF_TWO)
                + Math.pow(this.y - other.y, POW_OF_TWO));
    }

    /**
     * Threshold boolean method that return true if the difference between
     *  two numbers is at least EPSILON.
     *
     * @param a double a
     * @param b double b
     * @return the boolean
     */
    public static boolean threshold(double a, double b) {
        return  (Math.abs(a - b) < EPSILON);
    }

    /**
     * equals method return true if the points are equal, false otherwise.
     * The method returns an answer with an accuracy of EPSILON
     *
     * @param other the other point with which we would like to compare
     * @return method return true if the points are equal, false otherwise
     */
    public boolean equals(Point other) {

        return (threshold(this.x, other.x) && threshold(this.y, other.y));
    }

    /**
     * getX method return the x value of this point.
     *
     * @return the x value of this point
     */
    public double getX() {
        // Return the x values of this point
        return this.x;
    }

    /**
     * getY method return the y value of this point.
     *
     * @return the y value of this point
     */
    public double getY() {
        // Return the y values of this point
        return this.y;
    }

    /**
     * SetX method sets the x value of the point.
     *
     * @param x the new x value
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * SetY method sets the y value of the point.
     *
     * @param y the new y value
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * generateRandomPoint method.
     *
     * @param blackWilde  the black wilde
     * @param blackHeight the black height
     * @return return random center point in a black.
     */
    public static Point generateRandomPoint(double blackWilde, double blackHeight) {
        // create a random-number generator
        Random rand = new Random();
        // generates random x,y values for the center point.
        double x = 0 + blackWilde * rand.nextDouble();
        double y = 0 + blackHeight * rand.nextDouble();
        // return this center point with those random x,y values
        return new Point(x, y);
    }

}

