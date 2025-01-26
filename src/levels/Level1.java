//  Guy Rosenthal
package levels;

import SpriteAndCollidables.Block;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import SpriteAndCollidables.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * ArcadeGame - Level1 class.
 * represents the first level in the game.
 *
 * @author Guy Rozenthal 
 */
public class Level1 implements LevelInformation {
    // Finals
    /**
     * The constant SCREEN_WIDTH.
     */
    public static final int SCREEN_WIDTH = 800;
    /**
     * The constant BLOCK_WIDTH.
     */
    public static final int BLOCK_WIDTH = 25;

    /**
     * The constant FIRST_ROW_HEIGHT.
     */
    public static final int FIRST_ROW_HEIGHT = 200;
    /**
     * The constant Velocity of ball1.
     */
    public static final Velocity BALL1_V = new Velocity(0, 4);
    /**
     * The constant PADDLE_SPEED.
     */
    public static final int PADDLE_SPEED = 7;
    /**
     * The constant PADDLE_WIDTH.
     */
    public static final int PADDLE_WIDTH = 100;


    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new LinkedList<>();
        velocities.add(BALL1_V);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(50, 111, 203, 255));
                d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
                d.setColor(new Color(49, 152, 3, 255));
                d.fillRectangle(0, 400, d.getWidth(), d.getHeight() - 400);
                d.setColor(new Color(166, 162, 162, 255));
                d.fillOval(SCREEN_WIDTH / 2 - 70, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 150, 50, 100);
                d.fillOval(SCREEN_WIDTH / 2 + 20, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 150, 50, 100);
                d.setColor(new Color(255, 0, 234, 255));
                d.fillOval(SCREEN_WIDTH / 2 - 65, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 150, 40, 90);
                d.fillOval(SCREEN_WIDTH / 2 + 25, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 150, 40, 90);
                d.setColor(Color.lightGray);
                d.drawOval(SCREEN_WIDTH / 2 - 70, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 150, 50, 100);
                d.drawOval(SCREEN_WIDTH / 2 + 20, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 150, 50, 100);
                d.setColor(new Color(166, 162, 162, 255));
                d.fillCircle(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 220, 150);
                d.setColor(Color.black);
                d.drawCircle(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 220, 150);
                d.setColor(new Color(166, 162, 162, 255));
                d.fillCircle(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2, 75);
                d.setColor(Color.black);
                d.drawCircle(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2, 75);
                d.setColor(new Color(246, 117, 117, 255));
                d.fillCircle(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 35, 15);
                d.setColor(Color.black);
                d.drawCircle(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 35, 15);
                d.setColor(Color.black);
                d.drawLine(SCREEN_WIDTH / 2 - 30, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 40,
                        SCREEN_WIDTH / 2 - 10, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 20);
                d.drawLine(SCREEN_WIDTH / 2 - 10, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 40,
                        SCREEN_WIDTH / 2 - 30, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 20);
                d.drawLine(SCREEN_WIDTH / 2 + 30, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 40,
                        SCREEN_WIDTH / 2 + 10, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 20);
                d.drawLine(SCREEN_WIDTH / 2 + 10, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 40,
                        SCREEN_WIDTH / 2 + 30, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 20);
                d.drawLine(SCREEN_WIDTH / 2 - 10, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 7,
                        SCREEN_WIDTH / 2 + 10, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 7);
                d.drawLine(SCREEN_WIDTH / 2 - 10, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 7,
                        SCREEN_WIDTH / 2 + 10, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 7);
                d.setColor(new Color(197, 9, 9, 255));
                d.drawCircle(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2, 50);
                d.drawCircle(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2, 100);
                d.drawCircle(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2, 150);
                d.drawLine(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2,
                        SCREEN_WIDTH / 2 + 175, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2);
                d.drawLine(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2,
                        SCREEN_WIDTH / 2 - 175, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2);
                d.drawLine(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2,
                        SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 175);
                d.drawLine(SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2,
                        SCREEN_WIDTH / 2, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 - 175);
                d.setColor(Color.black);
                d.drawLine(SCREEN_WIDTH / 2 + 10, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2,
                        SCREEN_WIDTH / 2 - 10, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2);
                d.setColor(new Color(166, 162, 162, 255));
                d.fillCircle(SCREEN_WIDTH / 2 - 150, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 150, 25);
                d.fillCircle(SCREEN_WIDTH / 2 + 150, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 150, 25);
                d.fillCircle(SCREEN_WIDTH / 2 - 100, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 360, 25);
                d.fillCircle(SCREEN_WIDTH / 2 + 100, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 360, 25);
                d.setColor(Color.black);
                d.drawCircle(SCREEN_WIDTH / 2 - 150, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 150, 25);
                d.drawCircle(SCREEN_WIDTH / 2 + 150, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 150, 25);
                d.drawCircle(SCREEN_WIDTH / 2 - 100, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 360, 25);
                d.drawCircle(SCREEN_WIDTH / 2 + 100, FIRST_ROW_HEIGHT + BLOCK_WIDTH / 2 + 360, 25);
                d.setColor(new Color(218, 157, 4, 255));
                d.fillCircle(150, 175, 100);
                d.setColor(new Color(218, 186, 4, 255));
                d.fillCircle(150, 175, 90);
            }

            @Override
            public void timePassed() {
            }
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new LinkedList<>();
        Block b1 = new Block(new Rectangle(
                new Point((((double) SCREEN_WIDTH / 2) - ((double) BLOCK_WIDTH / 2)), FIRST_ROW_HEIGHT),
                BLOCK_WIDTH, BLOCK_WIDTH), Color.red);
        blocks.add(b1);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
