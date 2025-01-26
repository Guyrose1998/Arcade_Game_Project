//  Guy Rosenthal
package GameSupporters;


import SpriteAndCollidables.Sprite;
import biuoop.DrawSurface;

import java.util.LinkedList;

/**
 * ArcadeGame - GameSupporters.SpriteCollection class.
 * GameSupporters.SpriteCollection will hold a collection of sprites.
 *
 * @author Guy Rozenthal 
 */
public class SpriteCollection {
    /**
     * The GameSupporters.Ass3Game.Interfaces.Sprite list.
     */
// Fields
    private LinkedList<Sprite> spriteList;

    /**
     * SpriteCollection constructor instantiates a new Sprite collection.
     */
    public SpriteCollection() {
        this.spriteList = new LinkedList<>();
    }

    /**
     * getSpriteList method return the list linked list of Sprites.
     *
     * @return the linked list of Sprites
     */
    public LinkedList<Sprite> getSpriteList() {
        return this.spriteList;
    }

    /**
     * addSprite method add Sprite s to the list.
     *
     * @param s the s Sprite need to add to the list
     */
    public void addSprite(Sprite s) {
        getSpriteList().addFirst(s);
    }

    /**
     * removeSprite method remove Sprite s from the list.
     *
     * @param s the s Sprite that need to remove from the list
     */
    public void removeSprite(Sprite s) {
        getSpriteList().remove(s);
    }


    /**
     * notifyAllTimePassed method call timePassed() on all sprites..
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < getSpriteList().size(); i++) {
            getSpriteList().get(i).timePassed();
        }
    }

    /**
     * drawAllOn method call drawOn(d) on all sprites. .
     *
     * @param d the d DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < getSpriteList().size(); i++) {
            getSpriteList().get(i).drawOn(d);
        }
    }
}