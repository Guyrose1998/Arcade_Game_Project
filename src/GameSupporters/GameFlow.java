// Guy Rosenthal
package GameSupporters;

import Animations.Animation;
import Animations.EndScreen;
import Animations.KeyPressStoppableAnimation;
import levels.LevelInformation;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * ArcadeGame - The GameFlow class.
 * manages the flow of the game, including running levels and displaying end screens.
 *
 * @author Guy Rozenthal 
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;
    private Counter score;

    /**
     * Creates a new GameFlow instance.
     *
     * @param animationRunner the animation runner
     * @param keyboardSensor  the keyboard sensor
     * @param gui             the gui
     */
    public GameFlow(AnimationRunner animationRunner, KeyboardSensor keyboardSensor, GUI gui) {
        this.animationRunner = animationRunner;
        this.keyboardSensor = keyboardSensor;
        this.gui = gui;
        this.score = new Counter(0);
    }

    /**
     * getAnimationRunner method gets the animation runner.
     *
     * @return the animation runner
     */
    public AnimationRunner getAnimationRunner() {
        return animationRunner;
    }

    /**
     * getKeyboardSensor method gets the keyboard sensor.
     *
     * @return the keyboard sensor
     */
    public KeyboardSensor getKeyboardSensor() {
        return keyboardSensor;
    }

    /**
     * getGui method gets the gui.
     *
     * @return the gui
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * getScore method gets the score.
     *
     * @return the score
     */
    public Counter getScore() {
        return score;
    }

    /**
     * runLevels method Runs the specified list of levels.
     *
     * @param levels the levels list
     */
    public void runLevels(List<LevelInformation> levels) {
        Animation loseScreen = new EndScreen(false, getScore());
        Animation winScreen = new EndScreen(true, getScore());
        for (int levelNum = 0; levelNum < levels.size(); levelNum++) {

            GameLevel level = new GameLevel(levels.get(levelNum), getAnimationRunner(),
                    getKeyboardSensor(), getGui(), getScore());
            level.initialize();
            while (level.getBlocksCounter().getValue() > 0 && level.getBallsCounter().getValue() > 0) {
                level.run();
                // if the player lost all the balls of this level
                if (level.getBallsCounter().getValue() == 0) {
                    // run loseScreen.
                    getAnimationRunner().run(new KeyPressStoppableAnimation(getKeyboardSensor(),
                            KeyboardSensor.SPACE_KEY, loseScreen));
                    if (level.shouldStop()) {
                        // the player pressed the space key
                       // getGui().close();
                    }
                }
            }
            if (levelNum == levels.size() - 1) {
                // if the player remove all the blocks
                if (level.getBlocksCounter().getValue() == 0) {
                    // run winScreen.
                    getAnimationRunner().run(new KeyPressStoppableAnimation(getKeyboardSensor(),
                            KeyboardSensor.SPACE_KEY, winScreen));
                    if (level.shouldStop()) {
                        // the player pressed the space key
                      //  getGui().close();
                    }
                }

            }
        }

    }
}

