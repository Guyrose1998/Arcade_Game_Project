//  Guy Rosenthal
package SpriteAndCollidables;

import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;

/**
 * ArcadeGame - The interface Collidable.
 *
 * @author Guy Rozenthal 
 */
public interface Collidable {
    /**
     * getCollisionRectangle method return the "collision shape" of the object.
     *
     * @return the collision rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Hit method notify the object that we collided with it at collisionPoint
     * with a given velocity The return is the new velocity expected after the
     * hit (based on the force the object inflicted on us).
     *
     * @param hitter the Ball hitter
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the new velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

}

