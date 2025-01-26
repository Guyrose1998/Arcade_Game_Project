//  Guy Rosenthal
package Animations;

import GameSupporters.GameLevel;
import GameSupporters.SpriteCollection;
import biuoop.DrawSurface;
import levels.LevelInformation;

import java.awt.Color;

/**
 * ArcadeGame - CountdownAnimation class
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds,
 * before it is replaced with the next one.
 *
 * @author Guy Rozenthal 
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private LevelInformation currentLevel;
    private SpriteCollection gameScreen;
    private long startTime;
    private boolean stop;
    private boolean firstFrame;


    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     * @param currentLevel the current level
     */
    public CountdownAnimation(double numOfSeconds, int countFrom,
                              LevelInformation currentLevel, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.currentLevel = currentLevel;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.firstFrame = true;
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.firstFrame) {
            this.startTime = System.currentTimeMillis();
            this.firstFrame = false;
        }
        this.currentLevel.getBackground();
        this.gameScreen.drawAllOn(d);
        long currentMillisecond = System.currentTimeMillis();
        double singleCountLength = this.numOfSeconds / ((double) this.countFrom + 1);
        int currentNumber = (int) ((double) (1 + this.countFrom)
                - (double) (currentMillisecond - this.startTime) / (singleCountLength * 1000.0));
        d.setColor(Color.WHITE);
        if (currentNumber >= 1) {
            d.drawText(d.getWidth() / 2 - 24, d.getHeight() / 2, "" + currentNumber, 48);
        } else {
            d.drawText(d.getWidth() / 2 - 48, d.getHeight() / 2, "go!", 48);
        }

        if ((double) (currentMillisecond - this.startTime) > this.numOfSeconds * 1000.0) {
            this.stop = true;
        }
        d.setColor(Color.white);
        String level = "Level Name: " + this.currentLevel.levelName();
        d.drawText(GameLevel.SCREEN_WIDTH - 250, GameLevel.BORDER_SIZE, level, 20);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
