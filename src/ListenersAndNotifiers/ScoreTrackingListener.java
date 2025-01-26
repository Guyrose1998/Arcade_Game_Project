// Guy Rosenthal
package ListenersAndNotifiers;

import GameSupporters.Counter;
import SpriteAndCollidables.Ball;
import SpriteAndCollidables.Block;

/**
 * ArcadeGame - ScoreTrackingListener class.
 * update currentScore counter when blocks are being hit and removed to update the score.
 *
 * @author Guy Rozenthal 
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // increase the score by 5 point.
        this.currentScore.increase(5);
    }
}

