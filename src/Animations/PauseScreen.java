//  Guy Rosenthal
package Animations;

import biuoop.DrawSurface;

import java.awt.Color;


/**
 * ArcadeGame - PauseScreen class.
 * this animation adding an option to pause the game when pressing the p key.
 * and display a screen with the paused message.
 * until the stop key is pressed.
 *
 * @author Guy Rozenthal 
 */
public class PauseScreen implements Animation {

    /**
     * Instantiates a new Pause screen.
     */
    public PauseScreen() {
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(10, 26, 68));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.white);
        d.drawText(d.getWidth() / 2 - 50, d.getHeight() / 2, "paused", 40);
        d.drawText(d.getWidth() / 2 - 150, d.getHeight() / 2 + 50, "press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}


