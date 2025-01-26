// Guy Rosenthal
package ListenersAndNotifiers;


/**
 * ArcadeGame - the interface HitNotifier.
 *
 * @author Guy Rozenthal
 */
public interface HitNotifier {
    /**
     * addHitListener method add hl as a listener to hit events.
     *
     * @param hl the listener that need to add to hit events
     */
    void addHitListener(HitListener hl);

    /**
     * removeHitListener remove hl from the list of listeners to hit events.
     *
     * @param hl the listener thar need to remove from hit events
     */
    void removeHitListener(HitListener hl);
}

