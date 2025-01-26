//  Guy Rosenthal
package Animations;

import GameSupporters.Counter;
import biuoop.DrawSurface;

import java.awt.Color;


/**
 * ArcadeGame - EndScreen class.
 * represents the screen that is displayed at the end of the game,
 * indicating whether the player has won or lost and what was his score.
 *
 * @author Guy Rozenthal 
 */
public class EndScreen implements Animation {
    private Counter score;
    private boolean isWin;

    /**
     * Instantiates a new EndScreen.
     *
     * @param isWin flag indicating whether the player has won
     * @param score the player's score
     */
    public EndScreen(boolean isWin, Counter score) {
        this.score = score;
        this.isWin = isWin;
    }

    /**
     * isWin method checks if the player has won.
     *
     * @return true if the player has won, false otherwise
     */
    public boolean isWin() {
        return isWin;
    }

    /**
     * getScore method gets the player's score.
     *
     * @return the player's score
     */
    public Counter getScore() {
        return score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(10, 26, 68));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.white);
        String scoreSt = "your score is: ";
        if (isWin()) {
            // Display win message
            String win = "you win!";
            d.drawText(d.getWidth() / 2 - 100, d.getHeight() / 2, win, 40);
            d.drawText(d.getWidth() / 2 - 150, d.getHeight() / 2 + 50, scoreSt + getScore().getValue(), 40);
        } else {
            // Display loss message
            String lost = "Game Over!";
            d.drawText(d.getWidth() / 2 - 125, d.getHeight() / 2, lost, 40);
            d.drawText(d.getWidth() / 2 - 150, d.getHeight() / 2 + 50, scoreSt + getScore().getValue(), 40);
        }
        // display exit message
        d.drawText(d.getWidth() / 2 - 140, d.getHeight() / 2 + 100, "press space to exit", 32);

    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}

