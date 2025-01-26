//  Guy Rosenthal
package GameSupporters;

import Animations.CountdownAnimation;
import Animations.KeyPressStoppableAnimation;
import Animations.PauseScreen;
import ListenersAndNotifiers.BallRemover;
import ListenersAndNotifiers.BlockRemover;
import ListenersAndNotifiers.ScoreTrackingListener;
import SpriteAndCollidables.ScoreIndicator;
import SpriteAndCollidables.Sprite;
import SpriteAndCollidables.Ball;
import SpriteAndCollidables.Block;
import SpriteAndCollidables.Paddle;
import SpriteAndCollidables.Collidable;
import Geometry.Point;
import Geometry.Rectangle;
import Animations.Animation;
import levels.LevelInformation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * ArcadeGame - GameLevel class.
 * GameLevel class displying a given level, displaying pause screen,
 * and in charge of the animation.
 *
 * @author Guy Rozenthal 
 */
public class GameLevel implements Animation {

// Finals
    /**
     * The constant SCREEN_WIDTH.
     */
    public static final int SCREEN_WIDTH = 800;
    /**
     * The constant SCREEN_HEIGHT.
     */
    public static final int SCREEN_HEIGHT = 600;
    /**
     * The constant BORDER_SIZE.
     */
    public static final int BORDER_SIZE = 25;
    /**
     * The constant BORDER_SIZE.
     */
    public static final int SCORE_HEIGHT = 30;
    /**
     * The constant PADDLE_HEIGHT.
     */
    public static final int PADDLE_HEIGHT = 10;

    /**
     * the constant RADIUS.
     */
    public static final int RADIUS = 6;
    /**
     * The starting point of the ball1.
     */
    public static final Point BALLS_START_P = new Point((double) SCREEN_WIDTH / 2,
            SCREEN_HEIGHT - BORDER_SIZE - PADDLE_HEIGHT - RADIUS);

    /**
     * The constant FRAMES_PER_SECOND.
     */
    public static final int FRAMES_PER_SECOND = 60;

    // filed
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * Instantiates a new GameLevel.
     *
     * @param levelInformation the level information
     * @param runner           the AnimationRunner runner
     * @param keyboard         the KeyboardSensor
     * @param gui              the gui
     * @param score            the score
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner runner, KeyboardSensor keyboard, GUI gui,
                     Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.gui = gui;
        this.blocksCounter = new Counter(0);
        this.ballsCounter = new Counter(0);
        this.score = score;
        this.runner = runner;
        this.keyboard = keyboard;
        this.levelInformation = levelInformation;
    }


    /**
     * Gets gui.
     *
     * @return the gui
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * Gets environment.
     *
     * @return the environment
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * Gets sprites.
     *
     * @return the sprites
     */
    public SpriteCollection getSprites() {
        return this.sprites;
    }

    /**
     * Gets counter.
     *
     * @return the counter
     */
    public Counter getBlocksCounter() {
        return this.blocksCounter;
    }

    /**
     * Gets balls counter.
     *
     * @return the balls counter
     */
    public Counter getBallsCounter() {
        return this.ballsCounter;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * Gets runner.
     *
     * @return the runner
     */
    public AnimationRunner getRunner() {
        return runner;
    }

    /**
     * Gets keyboard.
     *
     * @return the keyboard
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }

    /**
     * addCollidable method adding the c to the list of collidables.
     *
     * @param c the c Collidable to the list
     */
    public void addCollidable(Collidable c) {
        getEnvironment().addCollidable(c);
    }

    /**
     * removeCollidable method removing c from the list of collidables.
     *
     * @param c the removing collidable.
     */
    public void removeCollidable(Collidable c) {
        getEnvironment().removeCollidable(c);
    }

    /**
     * addSprite method adding the Sprite s to the list of Sprites.
     *
     * @param s the s Sprite to the list of Sprites.
     */
    public void addSprite(Sprite s) {
        getSprites().addSprite(s);
    }

    /**
     * removeSprite method removing the Sprite s from the list of Sprites.
     *
     * @param s the s Sprite that need to remove from the list of Sprites.
     */
    public void removeSprite(Sprite s) {
        getSprites().removeSprite(s);
    }

    /**
     * Gets level information.
     *
     * @return the level information
     */
    public LevelInformation getLevelInformation() {
        return levelInformation;
    }

    /**
     * gameBlocks method initialize all the block of the game and the borders.
     */
    public void gameBorders() {
        BlockRemover blockRemover = new BlockRemover(this, getBlocksCounter());
        BallRemover ballRemover = new BallRemover(this, getBallsCounter());
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(getScore());
        ScoreIndicator scoreIndicator = new ScoreIndicator(getScore());
        scoreIndicator.addToGame(this);
        Block scoreBlock = new Block(new Rectangle(
                new Point(0, 0),
                SCREEN_WIDTH, SCORE_HEIGHT), Color.BLACK);
        scoreBlock.addToGame(this);
        Block upperBorder = new Block(new Rectangle(
                new Point(0, SCORE_HEIGHT),
                SCREEN_WIDTH, BORDER_SIZE), Color.GRAY);
        upperBorder.addToGame(this);
        Block rightBorder = new Block(new Rectangle(
                new Point(SCREEN_WIDTH
                        - BORDER_SIZE, 0), BORDER_SIZE, SCREEN_HEIGHT),
                Color.gray);
        rightBorder.addToGame(this);
        Block leftBorder = new Block(new Rectangle(
                new Point(0, 0),
                BORDER_SIZE, SCREEN_HEIGHT), Color.gray);
        leftBorder.addToGame(this);
        // the killing block that remove the balls
        Block killingBlock = new Block(new Rectangle(new Point(0,
                SCREEN_HEIGHT), SCREEN_WIDTH, BORDER_SIZE),
                Color.black);
        killingBlock.addHitListener(ballRemover);
        killingBlock.addToGame(this);
        // the blocks of the game
        for (int i = 0; i < getLevelInformation().numberOfBlocksToRemove(); i++) {
            getBlocksCounter().increase(1);
            Block b = getLevelInformation().blocks().get(i);
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTrackingListener);
            b.addToGame(this);
        }
    }

    /**
     * initialize method is in charge of setting up the game - creating the
     * GUI, adding the blocks, adding the ball, the paddle, and adding any other
     * game objects.
     * In this assignment, the size of the GUI is 800 (width) * 600 (height).
     */
    public void initialize() {
        // the upper point of the paddle
        Point paddleUpperLeft =
                new Point(
                        ((double) SCREEN_WIDTH / 2) - ((double) getLevelInformation().paddleWidth() / 2),
                        SCREEN_HEIGHT - BORDER_SIZE - PADDLE_HEIGHT);
        // paddle initialization
        Paddle paddle = new Paddle(getGui(), new Rectangle(paddleUpperLeft,
                getLevelInformation().paddleWidth(), PADDLE_HEIGHT), new Color(255, 144, 55), 7);
        // adding the paddle to  game
        paddle.addToGame(this);
        // balls initialization
        for (int i = 0; i < getLevelInformation().numberOfBalls(); i++) {
            Ball ball = new Ball(BALLS_START_P, RADIUS, Color.red);
            ball.setVelocity(getLevelInformation().initialBallVelocities().get(i));
            getBallsCounter().increase(1);
            // adding the balls to the game
            ball.addToGame(this);
            ball.setGameEnvironment(getEnvironment());
        }
        // calling gameBorders() method
        gameBorders();
        // setting the background
        addSprite(getLevelInformation().getBackground());
        getRunner().run(new CountdownAnimation(2.0, 3, getLevelInformation(), getSprites()));

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Animation pauseScreen = new PauseScreen();
        getSprites().drawAllOn(d);
        d.setColor(Color.white);
        String level = "Level Name: " + getLevelInformation().levelName();
        d.drawText(SCREEN_WIDTH - 250, BORDER_SIZE, level, 20);
        getSprites().notifyAllTimePassed();
        if (getKeyboard().isPressed("p")) {
            getRunner().run(new KeyPressStoppableAnimation(getKeyboard(),
                    KeyboardSensor.SPACE_KEY, pauseScreen));
        }
        // if all the blacks was removed add 100 points to the score, and stop.
        if (getBlocksCounter().getValue() == 0) {
            getScore().increase(100);
            this.running = false;
        }
        // if all the balls was removed stop.
        if (getBallsCounter().getValue() == 0) {
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * run method Run the game - start the animation loop.
     */
    public void run() {
        this.running = true;
        getRunner().run(this);
    }
}