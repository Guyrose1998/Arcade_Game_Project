// Guy Rosenthal
package SpriteAndCollidables;

import GameSupporters.CollisionInfo;
import GameSupporters.GameLevel;
import GameSupporters.GameEnvironment;
import Geometry.Line;
import Geometry.Point;
import Geometry.Velocity;
import biuoop.DrawSurface;

import java.util.Random;

/**
 * ArcadeGame - geometry.Ball class.
 *
 * @author Guy Rosenthal 
 */
public class Ball implements Sprite {
    // Fields
    // the center point of the ball
    private Point center;
    // the radius of the ball
    private int r;
    // the color of the ball
    private java.awt.Color color;
    // the velocity of the ball
    private Velocity v;
    // the window frame
    private GameEnvironment gameEnvironment;

    // constructor

    /**
     * geometry.Ball constructor using the center point, radius and color of the ball.
     *
     * @param center the center point of the ball
     * @param r      the radius of the ball
     * @param color  the color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * geometry.Ball constructor using the x,y values of the center point,
     * the radius and color of the ball.
     *
     * @param x     the x value of the center point
     * @param y     the y value of the center point
     * @param r     the radius of the ball
     * @param color the color of the ball
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     * getX method return the x value of the center point of the ball.
     *
     * @return the x value of the center point of the ball
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * getY method return the y value of the center point of the ball.
     *
     * @return the y value of the center point of the ball
     */
    public int getY() {
        return (int) this.center.getY();
    }


    /**
     * getCenter method return the center of the ball.
     *
     * @return the center of the ball
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * getSize method return the size of the radius of the ball.
     *
     * @return the size of the radius of the ball
     */
    public int getSize() {
        return this.r;
    }

    /**
     * getColor method return the color of the ball.
     *
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }


    /**
     * setGameEnvironment set the game environment of the ball.
     *
     * @param gameEnvironment the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * getGameEnvironment return the game environment of the ball.
     *
     * @return return the game environment of the ball
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * setVelocity method set the velocity of the ball by given v velocity.
     *
     * @param v the velocity
     */
    public void setVelocity(Velocity v) {
        if (v == null) {
            this.v = new Velocity(0, 0);
        } else {
            this.v = v;
        }
    }

    /**
     * setVelocity method set the velocity of the ball by dx and dy values of
     * the given velocity.
     *
     * @param dx the dx value of the given velocity
     * @param dy the dy value of the given velocity
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * getVelocity method return the velocity of the ball.
     *
     * @return return the velocity of the ball
     */
    public Velocity getVelocity() {
        return this.v;
    }


    /**
     * moveOneStep method change the center point of the bull according to the
     * velocity, using applyToPoint method.
     * if the ball hit a collision object it will change it direction.
     */
    public void moveOneStep() {
        Point endOfTrajectory = getVelocity().applyToPoint(getCenter());
        Line trajectory = new Line(getCenter(), endOfTrajectory);
        CollisionInfo closestCollision = getGameEnvironment().
                getClosestCollision(trajectory);
        if (closestCollision != null) {
            setVelocity(closestCollision.collisionObject().
                    hit(this, closestCollision.collisionPoint(), getVelocity()));
            return;

        }
        this.center = getVelocity().applyToPoint(getCenter());

    }


    /**
     * generateRandomCenter method generate random center point for the ball.
     *
     * @param blackWilde  the black wilde
     * @param blackHeight the black height
     * @return return random center point in a black.
     */
    public static Point generateRandomCenter(double blackWilde, double blackHeight) {
        // create a random-number generator
        Random rand = new Random();
        // generates random x,y values for the center point.
        double x = 0 + blackWilde * rand.nextDouble();
        double y = 0 + blackHeight * rand.nextDouble();
        // return this center point with those random x,y values
        return new Point(x, y);
    }

    // Sprite
    @Override
    public void drawOn(DrawSurface d) {
        //generate the color of the ball
        d.setColor(getColor());
        // draw the ball on the surface
        d.fillCircle(getX(), getY(), getSize());
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * addToGame method in charge of adding the ball the game, calling the
     * appropriate game methods.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * removeFromGame method in charge of removing the ball from the game, calling the
     * appropriate game methods.
     *
     * @param g the g
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

}

