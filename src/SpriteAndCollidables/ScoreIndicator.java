package SpriteAndCollidables;

import GameSupporters.Counter;
import GameSupporters.GameLevel;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ArcadeGame - ScoreIndicator class.
 * ScoreIndicator Sprite charge of displaying the current score.
 *
 * @author Guy Rozenthal 
 */
public class ScoreIndicator implements Sprite {

    private Counter score;

    /**
     * Instantiates a new Score indicator.
     *
     * @param score the score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Counter getScore() {
        return score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        //generate the color of the text
        d.setColor(Color.white);
        // the text String.
        String strScore = "score: " + getScore().getValue();
        // drawing the text.
        d.drawText((GameLevel.SCREEN_WIDTH / 2) - (2 * strScore.length()), GameLevel.BORDER_SIZE, strScore, 20);
    }

    @Override
    public void timePassed() {
    }


    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}

