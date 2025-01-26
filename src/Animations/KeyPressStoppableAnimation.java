//  Guy Rosenthal
package Animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * ArcadeGame - KeyPressStoppableAnimation.
 * represents an animation that can be stopped by pressing a specific key.
 *
 * @author Guy Rozenthal 
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * Creates a new KeyPressStoppableAnimation instance.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * getsSensor method gets the keyboard sensor.
     *
     * @return the keyboard sensor
     */
    public KeyboardSensor getSensor() {
        return sensor;
    }

    /**
     * getskey method gets the key that stops the animation.
     *
     * @return the stop key
     */
    public String getKey() {
        return key;
    }

    /**
     * getAnimation method gets the animation to be stopped.
     *
     * @return the animation
     */
    public Animation getAnimation() {
        return animation;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        getAnimation().doOneFrame(d);
        if (!this.isAlreadyPressed && getSensor().isPressed(getKey())) {
            this.stop = true;
        }
        this.isAlreadyPressed = false;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
