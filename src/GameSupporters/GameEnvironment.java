//  Guy Rosenthal
package GameSupporters;

import Geometry.Line;
import Geometry.Point;
import SpriteAndCollidables.Collidable;

import java.util.LinkedList;
import java.util.List;

/**
 * ArcadeGame - GameEnvironment class.
 * During the game, there are going to be many objects a Ball can collide with.
 * The GameEnvironment class will be a collection of such things.
 * The ball will know the game environment, and will use it to check for
 * collisions and direct its movement.
 *
 * @author Guy Rozenthal 
 */
public class GameEnvironment {

// Fields

    /**
     * The game environment Collidable list.
     */
    private LinkedList<Collidable> collidableList;

    /**
     * Instantiates a new Game environment.
     */
    public GameEnvironment() {
        this.collidableList = new LinkedList<>();
    }

    /**
     * Gets collidable list.
     *
     * @return the collidable list
     */
    public List<Collidable> getCollidableList() {
        return this.collidableList;
    }

    /**
     * addCollidable method add the given collidable to the environment.
     *
     * @param c the given Collidable that need to be added to the environment
     */
    public void addCollidable(Collidable c) {
        this.collidableList.addFirst(c);
    }

    /**
     * removeCollidable method remove the given collidable from the environment.
     *
     * @param c the given Collidable that need to remove from the environment
     */
    public void removeCollidable(Collidable c) {
        getCollidableList().remove(c);
    }

    /**
     * getClosestCollision method, Assume an object moving from line.start() to
     * line.end(). If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory line
     * @return the collision info about the closest collision that is going
     * to occur. If this object will not collide with any of the collidables
     * in this collection, return null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // the closest intersection point to the start of the line with rect
        Collidable closestCollision = null;
        Point closestIntersection = null;
        // the length between the intersection to the start of the line
        double shortestTrajectory = Integer.MAX_VALUE;
        /*
         * a for loop that goes over all the collidables int the game
         * environment collidable list
         */
        for (int i = 0; i < getCollidableList().size(); i++) {
            /*
             * the intersection point with the i collision int the
             * list (can be null).
             */
            Point intersection = trajectory.
                    closestIntersectionToStartOfLine(getCollidableList().
                            get(i).getCollisionRectangle());
            // if there is an intersection point
            if (intersection != null) {
                // if this is the shortest trajectory
                if (shortestTrajectory > trajectory.start().distance(intersection)) {
                    shortestTrajectory = trajectory.start().distance(intersection);
                    closestIntersection = intersection;
                    closestCollision = getCollidableList().get(i);
                }
            }
        }
        if (closestCollision != null) {
            // return the collision info
            return new CollisionInfo(closestIntersection, closestCollision);
        }
        return null;
    }
}
