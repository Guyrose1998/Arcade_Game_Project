package levels;

import GameSupporters.GameLevel;
import SpriteAndCollidables.Block;
import Geometry.Rectangle;
import Geometry.Velocity;
import SpriteAndCollidables.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * ArcadeGame - Level2 class.
 * represents the second level in the game.
 *
 * @author Guy Rozenthal 
 */
public class Level2 implements LevelInformation {
    /**
     * The constant SCREEN_WIDTH.
     */
    public static final int SCREEN_WIDTH = 800;
    /**
     * The constant BLOCK_WIDTH.
     */
    public static final int BLOCK_WIDTH = 50;

    /**
     * The constant FIRST_ROW_HEIGHT.
     */
    public static final int FIRST_ROW_HEIGHT = 300;
    /**
     * The constant BALLS_SPEED.
     */
    public static final int BALLS_SPEED = 6;
    /**
     * The constant BALL1_V.
     */
    public static final Velocity BALL1_V = Velocity.fromAngleAndSpeed(10, BALLS_SPEED);
    /**
     * The constant Velocity of ball2.
     */
    public static final Velocity BALL2_V = Velocity.fromAngleAndSpeed(350, BALLS_SPEED);
    /**
     * The constant Velocity of ball3.
     */
    public static final Velocity BALL3_V = Velocity.fromAngleAndSpeed(20, BALLS_SPEED);
    /**
     * The constant Velocity of ball4.
     */
    public static final Velocity BALL4_V = Velocity.fromAngleAndSpeed(340, BALLS_SPEED);
    /**
     * The constant Velocity of ball5.
     */
    public static final Velocity BALL5_V = Velocity.fromAngleAndSpeed(30, BALLS_SPEED);
    /**
     * The constant Velocity of ball6.
     */
    public static final Velocity BALL6_V = Velocity.fromAngleAndSpeed(330, BALLS_SPEED);
    /**
     * The constant Velocity of ball7.
     */
    public static final Velocity BALL7_V = Velocity.fromAngleAndSpeed(40, BALLS_SPEED);
    /**
     * The constant Velocity of ball8.
     */
    public static final Velocity BALL8_V = Velocity.fromAngleAndSpeed(320, BALLS_SPEED);
    /**
     * The constant Velocity of ball9.
     */
    public static final Velocity BALL9_V = Velocity.fromAngleAndSpeed(50, BALLS_SPEED);
    /**
     * The constant Velocity of ball10.
     */
    public static final Velocity BALL10_V = Velocity.fromAngleAndSpeed(310, BALLS_SPEED);

    /**
     * The constant PADDLE_WIDTH.
     */
    public static final int PADDLE_WIDTH = 600;
    /**
     * The constant BORDER_SIZE.
     */
    public static final int BORDER_SIZE = 25;

    /**
     * The constant BLOCK_HEIGHT.
     */
    public static final int BLOCK_HEIGHT = 20;

    /**
     * The constant COLUMNS.
     */
    public static final int COLUMNS = 15;

    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new LinkedList<>();
        velocities.add(BALL1_V);
        velocities.add(BALL2_V);
        velocities.add(BALL3_V);
        velocities.add(BALL4_V);
        velocities.add(BALL5_V);
        velocities.add(BALL6_V);
        velocities.add(BALL7_V);
        velocities.add(BALL8_V);
        velocities.add(BALL9_V);
        velocities.add(BALL10_V);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "London Bridge";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(14, 178, 255, 255));
                d.fillRectangle(0, 0, d.getWidth(), FIRST_ROW_HEIGHT + BLOCK_HEIGHT);
                d.setColor(Color.black);
                d.fillRectangle(0, FIRST_ROW_HEIGHT + BLOCK_HEIGHT, SCREEN_WIDTH, 5 * BLOCK_HEIGHT);
                d.setColor(new Color(14, 178, 255, 255));
                d.fillCircle(GameLevel.BORDER_SIZE + BLOCK_WIDTH + 3 * BLOCK_WIDTH / 2,
                        FIRST_ROW_HEIGHT + BLOCK_HEIGHT + BLOCK_WIDTH + 3 * BLOCK_WIDTH / 2,
                        BLOCK_WIDTH + 3 * BLOCK_WIDTH / 5);
                d.fillCircle(GameLevel.BORDER_SIZE + (6 * BLOCK_WIDTH) + 3 * BLOCK_WIDTH / 2,
                        FIRST_ROW_HEIGHT + BLOCK_HEIGHT + BLOCK_WIDTH + 3 * BLOCK_WIDTH / 2,
                        BLOCK_WIDTH + 3 * BLOCK_WIDTH / 5);
                d.fillCircle(GameLevel.BORDER_SIZE + (11 * BLOCK_WIDTH) + 3 * BLOCK_WIDTH / 2,
                        FIRST_ROW_HEIGHT + BLOCK_HEIGHT + BLOCK_WIDTH + 3 * BLOCK_WIDTH / 2,
                        BLOCK_WIDTH + 3 * BLOCK_WIDTH / 5);
                d.fillCircle(GameLevel.BORDER_SIZE + BLOCK_WIDTH + 3 * BLOCK_WIDTH / 2,
                        FIRST_ROW_HEIGHT + BLOCK_HEIGHT + BLOCK_WIDTH + 3 * BLOCK_WIDTH / 2,
                        BLOCK_WIDTH + 3 * BLOCK_WIDTH / 5);

                d.setColor(new Color(48, 236, 19, 255));
                d.fillRectangle(0,
                        FIRST_ROW_HEIGHT + BLOCK_HEIGHT + BLOCK_WIDTH + 3 * BLOCK_WIDTH / 2,
                        d.getWidth(), d.getHeight() - FIRST_ROW_HEIGHT);
                d.setColor(Color.black);
                d.fillRectangle(GameLevel.BORDER_SIZE, FIRST_ROW_HEIGHT + BLOCK_HEIGHT,
                        BLOCK_WIDTH, d.getHeight() - FIRST_ROW_HEIGHT);
                d.fillRectangle(GameLevel.BORDER_SIZE + 4 * BLOCK_WIDTH, FIRST_ROW_HEIGHT + BLOCK_HEIGHT,
                        BLOCK_WIDTH * 2, d.getHeight() - FIRST_ROW_HEIGHT);
                d.fillRectangle(GameLevel.BORDER_SIZE + 9 * BLOCK_WIDTH, FIRST_ROW_HEIGHT + BLOCK_HEIGHT,
                        BLOCK_WIDTH * 2, d.getHeight() - FIRST_ROW_HEIGHT);
                d.fillRectangle(GameLevel.BORDER_SIZE + 14 * BLOCK_WIDTH, FIRST_ROW_HEIGHT + BLOCK_HEIGHT,
                        BLOCK_WIDTH, d.getHeight() - FIRST_ROW_HEIGHT);
                d.setColor(Color.GRAY);
                d.drawLine(GameLevel.BORDER_SIZE, FIRST_ROW_HEIGHT + 3 * BLOCK_HEIGHT,
                        SCREEN_WIDTH - GameLevel.BORDER_SIZE, FIRST_ROW_HEIGHT + 60);
                for (int i = 0; i < 300; i = i + 2 * BLOCK_HEIGHT) {
                    d.drawLine(GameLevel.BORDER_SIZE, FIRST_ROW_HEIGHT + BLOCK_HEIGHT + i,
                            GameLevel.BORDER_SIZE + BLOCK_WIDTH, FIRST_ROW_HEIGHT + BLOCK_HEIGHT + i);
                }
                for (int i = 0; i < 300; i = i + 2 * BLOCK_HEIGHT) {
                    d.drawLine(GameLevel.BORDER_SIZE + 4 * BLOCK_WIDTH, FIRST_ROW_HEIGHT + BLOCK_HEIGHT + i,
                            GameLevel.BORDER_SIZE + 6 * BLOCK_WIDTH, FIRST_ROW_HEIGHT + BLOCK_HEIGHT + i);
                }
                for (int i = 0; i < 300; i = i + 2 * BLOCK_HEIGHT) {
                    d.drawLine(GameLevel.BORDER_SIZE + 9 * BLOCK_WIDTH, FIRST_ROW_HEIGHT + BLOCK_HEIGHT + i,
                            GameLevel.BORDER_SIZE + 11 * BLOCK_WIDTH, FIRST_ROW_HEIGHT + BLOCK_HEIGHT + i);
                }
                for (int i = 0; i < 300; i = i + 2 * BLOCK_HEIGHT) {
                    d.drawLine(GameLevel.BORDER_SIZE + 14 * BLOCK_WIDTH, FIRST_ROW_HEIGHT + BLOCK_HEIGHT + i,
                            GameLevel.BORDER_SIZE + 15 * BLOCK_WIDTH, FIRST_ROW_HEIGHT + BLOCK_HEIGHT + i);
                }
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
        double upperLeftX = SCREEN_WIDTH - BORDER_SIZE - BLOCK_WIDTH;
        for (int blocksColum = 0; blocksColum < COLUMNS; blocksColum++) {
            Geometry.Point upperLeft = new Geometry.Point(upperLeftX - (BLOCK_WIDTH * blocksColum),
                    FIRST_ROW_HEIGHT);
            Block b = new Block(new Rectangle(upperLeft, BLOCK_WIDTH,
                    BLOCK_HEIGHT), new Color(157, 11, 36));
            blocks.add(b);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}