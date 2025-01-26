//  Guy Rosenthal
package Geometry;


import java.util.LinkedList;
import java.util.List;

/**
 * ArcadeGame - geometryPrimitives.Rectangle class.
 *
 * @author Guy Rozenthal 
 */

public class Rectangle extends java.awt.Rectangle {

    // Fields
    // the upper left point of the rectangle.
    private final Point upperLeft;
    // the width of the rectangle.
    private final double width;
    // the height of the rectangle.
    private final double height;

// Constructors

    /**
     * A rectangle constructor that Create a new rectangle
     * with location and width/height.
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * intersectionPoints method return a (possibly empty) List of intersection
     * points of the rectangle with the specified line.
     *
     * @param line the line
     * @return a (possibly empty) List of intersection points of the rectangle
     * with the specified line.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new LinkedList<>();
        // check if the intersection is with the upper line of the rectangle.
        if (line.intersectionWith(getUpperLine()) != null) {
            // adding to the list
            intersectionPoints.add(line.intersectionWith(getUpperLine()));
        }
        // check if the intersection is with the left line of the rectangle.
        if (line.intersectionWith(getLeftLine()) != null) {
            // adding to the list
            intersectionPoints.add(line.intersectionWith(getLeftLine()));
        }
        // check if the intersection is with the lower line of the rectangle.
        if (line.intersectionWith(getLowerLine()) != null) {
            // adding to the list
            intersectionPoints.add(line.intersectionWith(getLowerLine()));
        }
        // check if the intersection is with the right line of the rectangle.
        if (line.intersectionWith(getRightLine()) != null) {
            // adding to the list
            intersectionPoints.add(line.intersectionWith(getRightLine()));
        }
        // return the list
        return intersectionPoints;
    }

    /**
     * getWidth method return the width of the rectangle.
     *
     * @return the width of the rectangle.
     */

    public double getWidth() {
        return this.width;
    }

    /**
     * getHeight method return the height of the rectangle.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * getUpperLeft method return the upper left point of the rectangle.
     *
     * @return the upper left point of the rectangle.
     */

    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * getUpperRight method return the upper right point of the rectangle.
     *
     * @return the upper right point of the rectangle.
     */
    public Point getUpperRight() {
        return new Point(getUpperLeft().getX() + getWidth(),
                getUpperLeft().getY());

    }

    /**
     * getLowerRight method return the lower right point of the rectangle.
     *
     * @return the lower right point of the rectangle.
     */
    public Point getLowerLeft() {
        return new Point(getUpperLeft().getX(),
                getUpperLeft().getY() + getHeight());

    }

    /**
     * getLowerLeft method return the lower left point of the rectangle.
     *
     * @return the lower left point of the rectangle.
     */
    public Point getLowerRight() {
        return new Point(getUpperLeft().getX() + getWidth(),
                getUpperLeft().getY() + getHeight());
    }
    /**
     * getUpperLine method return the upper line of the rectangle.
     *
     * @return the upper line of the rectangle.
     */
    public Line getUpperLine() {
        return new Line(getUpperLeft(), getUpperRight());
    }
    /**
     * getLowerLine method return the lower line of the rectangle.
     *
     * @return the lower line of the rectangle.
     */
    public Line getLowerLine() {
        return new Line(getLowerLeft(), getLowerRight());
    }
    /**
     * getLeftLine method return the left line of the rectangle.
     *
     * @return the left line of the rectangle.
     */
    public Line getLeftLine() {
        return new Line(getUpperLeft(), getLowerLeft());
    }
    /**
     * getRightLine method return the right line of the rectangle.
     *
     * @return the right line of the rectangle.
     */
    public Line getRightLine() {
        return new Line(getUpperRight(), getLowerRight());
    }

}
