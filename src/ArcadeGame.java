// 208704049 Guy Rosenthal

import GameSupporters.GameFlow;
import GameSupporters.GameLevel;
import GameSupporters.AnimationRunner;
import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.LevelInformation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.util.LinkedList;
import java.util.List;


/**
 * ArcadeGame class.
 * is the main class of the game.
 * it runs the game and handles the game levels based on the input arguments.
 *
 * @author Guy Rozenthal 208704049
 */
public class ArcadeGame {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<LevelInformation> gameLevels = new LinkedList<>();
        List<Integer> gameLevelsOrder = new LinkedList<>();
        // enter the input from args array to gameLevelsOrder list.
        for (int i = 0; i < args.length; i++) {
            // will add only legal input (the numbers 1-3)
            if (args[i].matches("[1-3]?")) {
                gameLevelsOrder.add(Integer.parseInt(args[i]));
            }
        }
        // the input was illegal or no input was inserted to the args array.
        if (gameLevelsOrder.size() == 0) {
            gameLevels.add(new Level1());
            gameLevels.add(new Level2());
            gameLevels.add(new Level3());

        } else {
            /*
             * adding the game levels according to the input order,
             * some of the input was legal and inserted to the gameLevelsOrder list.
             */
            for (int j = 0; j < gameLevelsOrder.size(); j++) {
                if (gameLevelsOrder.get(j) == 1) {
                    gameLevels.add(new Level1());
                }
                if (gameLevelsOrder.get(j) == 2) {
                    gameLevels.add(new Level2());
                }
                if (gameLevelsOrder.get(j) == 3) {
                    gameLevels.add(new Level3());
                }
            }
        }
        // create the necessary game objects and run the levels
        GUI gui = new GUI("game", GameLevel.SCREEN_WIDTH, GameLevel.SCREEN_HEIGHT);
        AnimationRunner runner = new AnimationRunner(gui, GameLevel.FRAMES_PER_SECOND, new Sleeper());
        KeyboardSensor keyboard = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(runner, keyboard, gui);
        gameFlow.runLevels(gameLevels);
    }
}
