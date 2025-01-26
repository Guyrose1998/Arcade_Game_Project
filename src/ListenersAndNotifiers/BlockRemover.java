//  Guy Rosenthal
package ListenersAndNotifiers;

import GameSupporters.Counter;
import GameSupporters.GameLevel;
import SpriteAndCollidables.Ball;
import SpriteAndCollidables.Block;

/**
 * ArcadeGame - BlockRemover class.
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author Guy Rozenthal 
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param gameLevel          the game
     * @param removedBlocks the number ot the remaining blocks.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public GameLevel getGame() {
        return gameLevel;
    }

    /**
     * Gets remaining blocks.
     *
     * @return the remaining blocks Counter
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // decrease the number of blocks Counter by one.
       getRemainingBlocks().decrease(1);
        // removing the block from the game.
        beingHit.removeFromGame(getGame());
        // removing this black HitListener
        beingHit.removeHitListener(this);
    }
}