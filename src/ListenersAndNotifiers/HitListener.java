//  Guy Rosenthal
package ListenersAndNotifiers;

import SpriteAndCollidables.Ball;
import SpriteAndCollidables.Block;

/**
 * ArcadeGame - the interface HitListener.
 *
 * @author Guy Rozenthal 
 */
public interface HitListener {
    /**
     * HitEvent method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the Block that being hit
     * @param hitter   the hitter Ball that's doing the hitting
     */

    void hitEvent(Block beingHit, Ball hitter);
}