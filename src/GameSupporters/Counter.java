//  Guy Rosenthal
package GameSupporters;

/**
 * ArcadeGame - Counter class.
 * The Counter class represents a simple counter that can be incremented or decremented.
 *
 * @author Guy Rozenthal 
 */
public class Counter {
    private int count;

    /**
     * Instantiates a new Counter.
     *
     * @param count the count
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * increase method add some number to the count.
     *
     * @param number the number
     */

    public void increase(int number) {
        // add some number to current count.
        this.count = getValue() + number;
    }

    /**
     * decrease subtract some number form the count .
     *
     * @param number the number
     */

    public void decrease(int number) {
        // subtract some number from current count.
        this.count = getValue() - number;
    }

    /**
     * Gets value.
     *
     * @return the value of the Counter
     */
    public int getValue() {
        // get current count.
        return this.count;
    }
}