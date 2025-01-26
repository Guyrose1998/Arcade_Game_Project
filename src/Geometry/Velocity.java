//  Guy Rosenthal
package Geometry;

/**
 * ArcadeGame - GeometryPrimitives.Velocity class
 * GeometryPrimitives.Velocity specifies the change in position on the `x` and the `y` axes.
 *
 * @author Guy Rozenthal 
 */
public class Velocity {
    // Fields
    // the change int position on the x axes
    private  double dx;
    // the change int position on the y axes
    private  double dy;

    // constructor

    /**
     * GeometryPrimitives.Velocity constructor using the change in position on
     * the `x` and the `y` axes.
     *
     * @param dx the change in position on the x axes
     * @param dy the change in position on the y axes
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * getDx return the dx of the velocity.
     *
     * @return the dx of the velocity
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * getDy return the dy of the velocity.
     *
     * @return the dy of the velocity
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * applyToPoint method Take a point with position (x,y) and return a new
     * point with position (x+dx, y+dy).
     *
     * @param p - the original point
     * @return a new point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        // return new point with position (x+dx, y+dy)
        return new Point(p.getX() + getDx(), p.getY() + getDy());
    }

    /**
     * fromAngleAndSpeed method get the velocity in terms of
     * angle and a speed and return the velocity in terms of (dx,dy).
     *
     * @param angle the angle of the velocity
     * @param speed the speed of the velocity
     * @return the velocity in terms of (dx,dy)
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        // finding dx and dy using trigonometry
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = -Math.cos(Math.toRadians(angle)) * speed;
        // return the velocity in terms of (dx,dy)
        return new Velocity(dx, dy);
    }

    /**
     * getSpeed method return the speed of GeometryPrimitives.Velocity.
     *
     * @return the speed of the GeometryPrimitives.Velocity
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.getDx(), 2) + Math.pow(this.getDy(), 2));
    }
}

