//  Guy Rosenthal
package Animations;


import biuoop.DrawSurface;

/**
 * ArcadeGame - The interface Animation.
 * Responsible for the game animation that shown on the screen.
 *
 * @author Guy Rozenthal 
 */
public interface Animation {
    /**
     * DoOneFrame method draws a single frame on the game screen.
     *
     * @param d the d DrawSurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * ShouldStop method indicates if the animation should stop.
     *
     * @return true or false.
     */
    boolean shouldStop();
}
