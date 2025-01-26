//  Guy Rosenthal
package SpriteAndCollidables;

import biuoop.DrawSurface;

/**
 * ArcadeGame - The interface Sprite.
 *
 * @author Guy Rozenthal 
 */
public interface Sprite {
    //Interfaces.Sprite
    /**
     * drawOn method draw the object we collided with.
     *
     * @param d the draw surface
     */
    void drawOn(DrawSurface d);

    /**
     * timePassed method notify the sprite that time has passed.
     */
    void timePassed();

}

