//  Guy Rosenthal
package Geometry;

import java.util.List;

/**
 * ArcadeGame - geometryPrimitives.Line class.
 *
 * @author Guy Rozenthal 
 */
public class Line {
    /**
     * The constant ZERO.
     */
// Finals
    static final double ZERO = 0.0;
    /**
     * The Divide by two.
     */
    static final double DIVIDE_BY_TWO = 2.0;

    // Fields
    // the start and end points of the line
    private  Point start;
    private  Point end;

    // constructors

    /**
     * geometryPrimitives.Line constructor using 2 points start, end.
     *
     * @param start the start point of the line
     * @param end   the end point of the line
     */
    public Line(Point start, Point end) {
        // The start point of the line
        this.start = start;
        // The end point of the line
        this.end = end;
    }

    /**
     * geometryPrimitives.Line constructor using the x,y values of the start and end points.
     *
     * @param x1 - x value of the start point
     * @param y1 - y value of the start point
     * @param x2 - x value of the end point
     * @param y2 - y value of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        // creating start and end points using geometryPrimitives.Point constructor
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);

    }

    /**
     * length method return the length of the line by using it start and end
     * points.
     *
     * @return the length of the line
     */
    public double length() {
        /*
         * finding the length of the line using the distance method between the
         * start point and the end point
         */
        return start.distance(end);
    }


    /**
     * middle methode return the middle point of the line.
     *
     * @return the middle point of the line
     */
    public Point middle() {
        /*
         * the middle point is the average of the X and Y values
         * between the start and end points
         */
        return new Point((start.getX() + end.getX()) / DIVIDE_BY_TWO,
                (start.getY() + end.getY()) / DIVIDE_BY_TWO);
    }

    /**
     * start method return the start point of the line.
     *
     * @return the start point of the line
     */
    public Point start() {
        // Returns the start point of the line
        return this.start;
    }

    /**
     * start method return the end point of the line.
     *
     * @return the end point of the line
     */
    public Point end() {
        // Returns the end point of the line
        return this.end;
    }

    /**
     * isIntersecting method return true if the lines intersect, false
     * otherwise.
     *
     * @param other the other line with which the test is performed
     * @return true if the lines intersect, false otherwise
     */
// Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
        // the min/max x, y values of this (l1) and the other (l2) lines
        double minL1X = Math.min(this.start.getX(), this.end.getX());
        double maxL1X = Math.max(this.start.getX(), this.end.getX());
        double minL1Y = Math.min(this.start.getY(), this.end.getY());
        double maxL1Y = Math.max(this.start.getY(), this.end.getY());
        double minL2X = Math.min(other.start.getX(), other.end.getX());
        double maxL2X = Math.max(other.start.getX(), other.end.getX());
        double minL2Y = Math.min(other.start.getY(), other.end.getY());
        double maxL2Y = Math.max(other.start.getY(), other.end.getY());
        // line l1  represents as a1x + b1y = c1
        double a1 = this.end.getY() - this.start.getY();
        double b1 = this.start.getX() - this.end.getX();
        // line l2  represents as a2x + b2y = c2
        double a2 = other.end.getY() - other.start.getY();
        double b2 = other.start.getX() - other.end.getX();

        double determinant = (a1 * b2) - (a2 * b1);
        /*
         * the lines have the same equation ot they are parallels
         */
        if (Point.threshold(determinant, ZERO)) {
            return (!(maxL1X < minL2X)) && (!(minL1X > maxL2X))
                    && (!(maxL1Y < minL2Y)) && (!(minL1Y > maxL2Y));
        }
        return this.intersectionWith(other) != null;

    }

    /**
     * intersectionWith return the intersection point if the lines intersect
     * and null otherwise.
     *
     * @param other the other line with which the test is performed
     * @return the intersection point if the lines intersect and null otherwise.
     */
    public Point intersectionWith(Line other) {
        //  the min/max x, y values of this (l1) and the other (l2) lines
        double minL1X = Math.min(this.start.getX(), this.end.getX());
        double maxL1X = Math.max(this.start.getX(), this.end.getX());
        double minL1Y = Math.min(this.start.getY(), this.end.getY());
        double maxL1Y = Math.max(this.start.getY(), this.end.getY());
        double minL2X = Math.min(other.start.getX(), other.end.getX());
        double maxL2X = Math.max(other.start.getX(), other.end.getX());
        double minL2Y = Math.min(other.start.getY(), other.end.getY());
        double maxL2Y = Math.max(other.start.getY(), other.end.getY());
        // line l1  represents as a1x + b1y = c1
        double a1 = this.end.getY() - this.start.getY();
        double b1 = this.start.getX() - this.end.getX();
        double c1 = ((a1 * this.start.getX()) + (b1 * this.start.getY()));
        // line l2  represents as a2x + b2y = c2
        double a2 = other.end.getY() - other.start.getY();
        double b2 = other.start.getX() - other.end.getX();
        double c2 = (a2 * other.start.getX()) + (b2 * other.start.getY());

        double determinant = (a1 * b2) - (a2 * b1);
        /*
         * the lines have the same equation or they are parallels
         */
        if (Point.threshold(determinant, ZERO)) {
            /*
             * If the lines have the same equation but only one
             * intersection point
             */
            if ((Point.threshold(minL1X, maxL2X) && Point.threshold(minL1Y, maxL2Y))
                    || (Point.threshold(maxL1X, minL2X) && Point.threshold(maxL1Y, minL2Y))
                    || (Point.threshold(maxL1X, minL2X) && Point.threshold(minL1Y, maxL2Y))
                    || (Point.threshold(minL1X, maxL2X) && Point.threshold(maxL1Y, minL2Y))) {
                // l1 start point equals l2 start point
                if (this.start.equals(other.start)) {
                    return this.start;
                }
                // l1 start point equals l2 start end
                if (this.start.equals(other.end)) {
                    return this.start;
                }
                // l1 end point equals l2 start point
                if (this.end.equals(other.start)) {
                    return this.end;
                }
                // l1 end point equals l2 end point
                if (this.end.equals(other.end)) {
                    return this.end;
                }
            }
            /*
             * the lines have the same equation but more than one
             * intersection point or the lines parallels
             */
            return null;
        }
        // the x value of the intersection point
        double intersectionX = ((b2 * c1) - (b1 * c2)) / determinant;
        // the y value of the intersection point
        double intersectionY = ((a1 * c2) - (a2 * c1)) / determinant;
        /*
         * if the intersection point is between the start point and the end
         * point of  both of the lines - return the intersection point
         */
        Point intersection = new Point(intersectionX, intersectionY);
        if (this.isOnLine(intersection) && other.isOnLine(intersection)) {
            return intersection;
        }
        return null;
    }

    /**
     * closestIntersectionToStartOfLine method return the closest intersection
     * point to the start point of the line with a rectangle.
     * If this line does not intersect with the rectangle, it will return null.
     *
     * @param rect the rectangle
     * @return the intersection point or null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        // making a list of the intersection points of the line with the rect
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        // the closest intersection point to the start of the line with rect
        Point closestIntersectionToStart = null;
        // the length between the intersection to the start of the line
        double shortestLength = Integer.MAX_VALUE;
        /*
         * a for loop that goes over all the intersection points and find the
         * closest one to the start point og the line
         */
        for (int i = 0; i < rect.intersectionPoints(this).size(); i++) {
            if (shortestLength > start().distance(intersectionPoints.get(i))) {
                shortestLength = start().distance(intersectionPoints.get(i));
                closestIntersectionToStart = intersectionPoints.get(i);
            }
        }
        return closestIntersectionToStart;
    }

    /**
     * equals method return true is the lines are equal, false otherwise.
     *
     * @param other the other line with which the test is performed
     * @return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        //the lines are equal
        return ((start().equals(other.start) && end().equals(other.end))
                || ((start().equals(other.end)
                && end().equals(other.start))));
    }

    /**
     * isOnLine return true if the given point is on the line, otherwise false.
     *
     * @param point the given point.
     * @return true if the given point is on the line, otherwise false.
     */
    public boolean isOnLine(Point point) {
        //  true - AC + CB == AB , false - AC + CB != AB
        return (Point.threshold(start().distance(point) + end().distance(point),
                start().distance(end())));
    }

}
