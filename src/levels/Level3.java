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
 * ArcadeGame- Level3 class.
 * represents the third level in the game.
 *
 * @author Guy Rozenthal 
 */
public class Level3 implements LevelInformation {
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
    public static final int FIRST_ROW_HEIGHT = 130;
    /**
     * The constant Velocity of ball1.
     */
    public static final Velocity BALL1_V = new Velocity(3, 5);
    /**
     * The constant Velocity of ball2.
     */
    public static final Velocity BALL2_V = new Velocity(-3, 5);

    /**
     * The constant PADDLE_WIDTH.
     */
    public static final int PADDLE_WIDTH = 450;

    /**
     * The constant BORDER_SIZE.
     */
    public static final int BORDER_SIZE = 20;

    /**
     * The constant BLOCK_HEIGHT.
     */
    public static final int BLOCK_HEIGHT = 20;

    /**
     * The constant ROWS.
     */
    public static final int ROWS = 6;

    /**
     * The constant COLUMNS.
     */
    public static final int COLUMNS = 12;

    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new LinkedList<>();
        velocities.add(BALL1_V);
        velocities.add(BALL2_V);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "Last Level";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(50, 111, 203, 255));
                d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
                d.setColor(new Color(49, 152, 3, 255));
                d.fillRectangle(0, 450, d.getWidth(), d.getHeight() - 150);
                //sun
                d.setColor(new Color(218, 157, 4, 255));
                d.fillCircle(150, 175, 100);
                d.setColor(new Color(218, 186, 4, 255));
                d.fillCircle(150, 175, 90);
                //clouds
                d.setColor(Color.white);
                d.fillCircle(300, 120, 30);
                d.fillCircle(330, 120, 30);
                d.fillCircle(315, 100, 30);
                d.fillCircle(330, 100, 30);
                d.fillCircle(290, 120, 30);
                d.fillCircle(500, 120, 30);
                d.fillCircle(530, 140, 30);
                d.fillCircle(515, 110, 30);
                d.fillCircle(530, 140, 30);
                d.fillCircle(490, 140, 30);
                d.fillCircle(700, 120, 30);
                d.fillCircle(730, 120, 30);
                d.fillCircle(715, 100, 30);
                d.fillCircle(690, 100, 30);
                // ear1
                d.setColor(new Color(246, 117, 117, 255));
                d.fillOval(90, 405, 50, 20);
                // body and head
                d.setColor(Color.white);
                d.fillRectangle(125, 400, 75, 75);
                d.fillRectangle(200, 400, 300, 100);
                d.setColor(Color.black);
                d.drawRectangle(125, 400, 75, 75);
                d.drawRectangle(200, 400, 300, 100);
                // legs
                d.fillRectangle(200, 500, 20, 50);
                d.fillRectangle(270, 500, 20, 50);
                d.fillRectangle(440, 500, 20, 50);
                d.fillRectangle(480, 500, 20, 50);
                // spots1
                d.setColor(Color.black);
                d.fillCircle(230, 420, 15);
                d.fillCircle(250, 420, 15);
                d.fillCircle(220, 430, 15);
                d.fillCircle(240, 430, 15);
                // ear2
                d.setColor(new Color(246, 117, 117, 255));
                d.fillOval(185, 405, 50, 20);
                //head
                d.setColor(Color.white);
                d.fillRectangle(125, 400, 75, 75);
                //eyes
                d.setColor(Color.black);
                d.fillCircle(140, 420, 10);
                d.fillCircle(180, 420, 10);
                d.setColor(Color.white);
                d.fillCircle(135, 420, 5);
                d.fillCircle(175, 420, 5);
                //mouth
                d.setColor(new Color(246, 117, 117, 255));
                d.fillRectangle(130, 470, 60, 20);
                d.setColor(new Color(246, 177, 43, 255));
                d.drawLine(145, 490, 145, 500);
                d.drawLine(145, 500, 175, 500);
                d.drawLine(175, 490, 175, 500);
                d.setColor(Color.black);
                // tail
                d.fillRectangle(500, 410, 50, 10);
                d.fillRectangle(545, 390, 5, 30);
                //spots
                d.fillCircle(250, 450, 15);
                d.fillCircle(270, 450, 15);
                d.fillCircle(240, 460, 15);
                d.fillCircle(260, 460, 15);
                d.fillCircle(330, 430, 15);
                d.fillCircle(350, 430, 15);
                d.fillCircle(320, 440, 15);
                d.fillCircle(340, 440, 15);
                d.fillCircle(430, 450, 15);
                d.fillCircle(450, 450, 15);
                d.fillCircle(420, 460, 15);
                d.fillCircle(440, 460, 15);
                d.fillCircle(390, 470, 15);
                d.fillCircle(410, 470, 15);
                d.fillCircle(380, 480, 15);
                d.fillCircle(400, 480, 15);
                d.fillCircle(430, 450, 15);
                d.fillCircle(450, 450, 15);
                d.fillCircle(420, 460, 15);
                d.fillCircle(440, 460, 15);


            }

            @Override
            public void timePassed() {

            }
        };
    }


    /**
     * Get colors arr color [ ].
     *
     * @return the color [ ]
     */
    public Color[] getColorsArr() {
        Color[] colorsArr = new Color[6];
        colorsArr[0] = new Color(157, 11, 36);
        colorsArr[1] = new Color(200, 131, 0);
        colorsArr[2] = new Color(224, 196, 12);
        colorsArr[3] = new Color(72, 148, 10);
        colorsArr[4] = new Color(17, 36, 148);
        colorsArr[5] = new Color(133, 34, 152);
        return colorsArr;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new LinkedList<>();
        for (int blocksRow = 0; blocksRow < ROWS; blocksRow++) {
            double upperLeftX = SCREEN_WIDTH - BORDER_SIZE - BLOCK_WIDTH;
            for (int blocksColum = 0; blocksColum < COLUMNS - blocksRow; blocksColum++) {
                Point upperLeft = new Point(upperLeftX - (BLOCK_WIDTH * blocksColum),
                        FIRST_ROW_HEIGHT + (BLOCK_HEIGHT * blocksRow));
                Block b = new Block(new Rectangle(upperLeft, BLOCK_WIDTH,
                        BLOCK_HEIGHT),
                        getColorsArr()[blocksRow]);
                blocks.add(b);
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
