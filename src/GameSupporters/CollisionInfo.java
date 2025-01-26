//Guy Rosenthal
package GameSupporters;


import Geometry.Point;
import SpriteAndCollidables.Collidable;

/**
 * ArcadeGame- CollisionInfo class.
 *
 * @author Guy Rozenthal 
 */
public class CollisionInfo {
    // Fields
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * CollisionInfo constructor instantiates a new Collision info.
     *
     * @param collisionPoint  the collision point
     * @param collisionObject the collision object
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * collisionPoint method return the point at which the collision occurs.
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * collisionObject return the collidable object involved in the collision.
     *
     * @return the collidable  object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}