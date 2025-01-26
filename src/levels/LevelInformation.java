//  Guy Rosenthal
package levels;

import SpriteAndCollidables.Block;
import Geometry.Velocity;
import SpriteAndCollidables.Sprite;

import java.util.List;

/**
 * ArcadeGame - The interface Level information.
 *
 * @author Guy Rozenthal 
 */
public interface LevelInformation {
    /**
     * numberOfBalls return the number of balls.
     *
     * @return the number of balls
     */
    int numberOfBalls();

    /**
     * initialBallVelocities method return list of velocities of the balls.
     *
     * @return the list of velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddleSpeed method return the speed of the paddle.
     *
     * @return the speed of the paddle
     */
    int paddleSpeed();

    /**
     * paddleWidth method return the paddle width.
     *
     * @return the width of the paddle
     */
    int paddleWidth();

    /**
     * levelName method return the level name. it will be displayed at the top of the screen.
     *
     * @return the name of the level
     */
    String levelName();

    /**
     * getBackground method returns a sprite with the background of the level.
     *
     * @return the background sprite
     */
    Sprite getBackground();

    /**
     * blocks method return the list of The Blocks that make up this level, each block contains
     * its size, color and location.  .
     *
     * @return the list of blocks
     */
    List<Block> blocks();

    /**
     * numberOfBlocksToRemove method return Number of blocks that should be removed
     * before the level is considered to be "cleared". This number should be <= blocks.size();
     *
     * @return the number of blocks
     */
    int numberOfBlocksToRemove();
}
