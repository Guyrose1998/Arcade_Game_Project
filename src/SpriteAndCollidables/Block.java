//  Guy Rosenthal
package SpriteAndCollidables;

import GameSupporters.GameLevel;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import ListenersAndNotifiers.HitListener;
import ListenersAndNotifiers.HitNotifier;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * ArcadeGame - geometry.Block class.
 *
 * @author Guy Rozenthal
 */
public class Block implements Collidable, Sprite, HitNotifier {
    // Fields
    private Rectangle rectangle;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * Black constructor that instantiates a new geometry.Block.
     *
     * @param rectangle the rectangle of the block
     * @param color     the color of the block
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * getRectangle method return the rectangle of the block.
     *
     * @return the rectangle of the block
     */
    public Rectangle getRectangle() {
        return this.rectangle;
    }

    /**
     * getColor method return the color of the block.
     *
     * @return the color of the block
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * getHitListeners return the hit listeners list.
     *
     * @return the hit listeners list.
     */
    public List<HitListener> getHitListeners() {
        return hitListeners;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }


    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        if (getCollisionRectangle().getUpperLine().isOnLine(collisionPoint)
                || getCollisionRectangle().getLowerLine().
                isOnLine(collisionPoint)) {
            // changing the velocity
            return new Velocity(currentVelocity.getDx(),
                    -currentVelocity.getDy());
        }
        // if hitting the left or right lines of the block
        if (getCollisionRectangle().getLeftLine().isOnLine(collisionPoint)
                || getCollisionRectangle().getRightLine().
                isOnLine(collisionPoint)) {
            // changing the velocity
            return new Velocity(-currentVelocity.getDx(),
                    currentVelocity.getDy());
        }
        //there is no hit so the velocity sty the same
        return currentVelocity;
    }

    // Interfaces.Sprite
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
    }

    /**
     * addToGame method in charge of adding the block to
     * the game, calling the appropriate game methods..
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * removeFromGame method remove a Block from the Game game.
     *
     * @param gameLevel the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        getHitListeners().add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        getHitListeners().remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(getHitListeners());
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}



