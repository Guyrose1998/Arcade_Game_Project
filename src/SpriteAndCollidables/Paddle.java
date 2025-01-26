// Guy Rosenthal
package SpriteAndCollidables;

import GameSupporters.GameLevel;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;


/**
 * ArcadeGame - geometry.Paddle class.
 *
 * @author Guy Rosenthal 
 */
public class Paddle implements Sprite, Collidable {
    /**
     * The constant PADDLE_MOVEMENT.
     */

    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private GUI gui;
    private int paddleSpeed;

    /**
     * geometry.Paddle constructor that instantiates a new geometry.Block.
     *
     * @param gui         the gui
     * @param rectangle   the rectangle of the block
     * @param color       the color of the block
     * @param paddleSpeed the paddle speed
     */
    public Paddle(GUI gui, Rectangle rectangle,
                  Color color, int paddleSpeed) {
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
        this.rectangle = rectangle;
        this.color = color;
        this.paddleSpeed = paddleSpeed;
    }

    /**
     * getRectangle method return the rectangle of the paddle.
     *
     * @return the rectangle of the paddle
     */
    public Rectangle getRectangle() {
        return this.rectangle;
    }

    /**
     * getColor method return the color of the paddle.
     *
     * @return the color of the paddle
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets paddle speed.
     *
     * @return the paddle speed
     */
    public int getPaddleSpeed() {
        return paddleSpeed;
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        double currentX = getRectangle().getUpperLeft().getX();
        if (currentX >= getPaddleSpeed() + GameLevel.BORDER_SIZE) {
            getRectangle().getUpperLeft().setX(currentX - getPaddleSpeed());
        } else {
            getRectangle().getUpperLeft().setX(GameLevel.BORDER_SIZE);
        }
    }

    /**
     * Move right.
     */
    public void moveRight() {
        double currentRightX = getRectangle().getUpperRight().getX();
        double currentLeftX = getRectangle().getUpperLeft().getX();
        double paddleSize = currentRightX - currentLeftX;
        if (currentLeftX + paddleSize + getPaddleSpeed() + GameLevel.BORDER_SIZE <= GameLevel.SCREEN_WIDTH) {
            getRectangle().getUpperLeft().setX(currentLeftX + getPaddleSpeed());
        } else {
            getRectangle().getUpperLeft().setX(GameLevel.SCREEN_WIDTH - paddleSize - GameLevel.BORDER_SIZE);
        }

    }

    // GameSupporters.Sprite
    @Override
    public void drawOn(DrawSurface surface) {
        //generate the color of the block
        surface.setColor(getColor());
        // draw the block on the surface as a filled rectangle
        surface.fillRectangle((int) getRectangle().getUpperLeft().getX(),
                (int) getRectangle().getUpperLeft().getY(),
                (int) getRectangle().getWidth(),
                (int) getRectangle().getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) getRectangle().getUpperLeft().getX(),
                (int) getRectangle().getUpperLeft().getY(),
                (int) getRectangle().getWidth(),
                (int) getRectangle().getHeight());
    }

    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(this.keyboard.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed(this.keyboard.RIGHT_KEY)) {
            moveRight();
        }
    }

    // Collidable
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double currentRightX = getRectangle().getUpperRight().getX();
        double currentLEFTX = getRectangle().getUpperLeft().getX();
        double paddleSize = currentRightX - currentLEFTX;
        if ((collisionPoint.getX() - getCollisionRectangle().getUpperLeft().
                getX()) / (paddleSize / 5) < 1) {
            return Velocity.fromAngleAndSpeed(300,
                    currentVelocity.getSpeed());
        }
        if ((collisionPoint.getX() - getCollisionRectangle().getUpperLeft().
                getX()) / (paddleSize / 5) < 2) {
            return Velocity.fromAngleAndSpeed(330,
                    currentVelocity.getSpeed());
        }
        if ((collisionPoint.getX() - getCollisionRectangle().getUpperLeft().
                getX()) / (paddleSize / 5) < 3) {
            return new Velocity(currentVelocity.getDx(),
                    -currentVelocity.getDy());
        }
        if ((collisionPoint.getX() - getCollisionRectangle().getUpperLeft().
                getX()) / (paddleSize / 5) < 4) {
            return Velocity.fromAngleAndSpeed(30,
                    currentVelocity.getSpeed());
        }
        if ((collisionPoint.getX() - getCollisionRectangle().getUpperLeft().
                getX()) / (paddleSize / 5) <= 5) {
            return Velocity.fromAngleAndSpeed(60,
                    currentVelocity.getSpeed());
        }

        // there is no hit so the velocity sty the same
        return currentVelocity;
    }


    /**
     * Add to game.
     *
     * @param g the game
     */
// Add this paddle to the game.
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}