// Guy Rosenthal
package GameSupporters;

import Animations.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;


/**
 * ArcadeGame- AnimationRunner class.
 * the looping code of the game.
 *
 * @author Guy Rozenthal 
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * Instantiates a new Animation runner.
     *
     * @param gui             the gui
     * @param framesPerSecond the frames per second
     * @param sleeper         the sleeper
     */
    public AnimationRunner(GUI gui, int framesPerSecond, Sleeper sleeper) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = sleeper;
    }

    /**
     * Gets gui.
     *
     * @return the gui
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * Gets frames per second.
     *
     * @return the frames per second
     */
    public int getFramesPerSecond() {
        return framesPerSecond;
    }

    /**
     * Gets sleeper.
     *
     * @return the sleeper
     */
    public Sleeper getSleeper() {
        return sleeper;
    }

    /**
     * Run.
     *
     * @param animation the animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / getFramesPerSecond();
        while (!animation.shouldStop()) {
            // timing
            long startTime = System.currentTimeMillis();
            DrawSurface d = getGui().getDrawSurface();
            // one frame of the animation
            animation.doOneFrame(d);
            getGui().show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                getSleeper().sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
