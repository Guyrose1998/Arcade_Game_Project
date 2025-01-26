// Guy Rosenthal
package ListenersAndNotifiers;

import GameSupporters.Counter;
import GameSupporters.GameLevel;
import SpriteAndCollidables.Ball;
import SpriteAndCollidables.Block;


/**
 * ArcadeGame - BallRemover class.
 * a BallRemover is in charge of removing balls from the game, as well as keeping count
 * of the number of balls that remain.
 *
 * @author Guy Rozenthal 
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Instantiates a new Block remover.
     *
     * @param gameLevel           the game of the ball
     * @param remainingBalls the number ot the remaining balls.
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public GameLevel getGame() {
        return this.gameLevel;
    }

    /**
     * Get remaining balls counter.
     *
     * @return the counter of the Balls
     */
    public Counter getRemainingBall() {
        return this.remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // decrease the number of balls Counter by one.
       getRemainingBall().decrease(1);
        // removing the ball from the game.
        hitter.removeFromGame(getGame());
    }
}
