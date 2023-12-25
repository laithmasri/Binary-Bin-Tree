/**
 * This is the key value pair class. I took the generic implementation of this
 * class from the OpenDSA.
 * 
 * @param <K>
 *            Represents the key.
 * @param <E>
 *            Represents the value.
 * 
 * 
 * @author laithalmasri
 * @version Sep 19th
 */
// KVPair class definition
public class KVPair<K extends Comparable<K>, E>
    implements Comparable<KVPair<K, E>> {
    private K theKey;
    private E theVal;

    /**
     * This is the constructor for the class.
     * 
     * @param k
     *            Represents the key.
     * @param v
     *            Represents the value.
     */
    KVPair(K k, E v) {
        theKey = k;
        theVal = v;
    }


    /**
     * This method compared the KVPairs.
     * 
     * @param it
     *            Represents the KVPair to compare.
     * @return Positive if greater, negative
     *         if less, and zero if equal.
     */
    public int compareTo(KVPair<K, E> it) {
        return theKey.compareTo(it.key());
    }


    /**
     * Compare KVPairs
     * 
     * @param it
     *            object to compare.
     * @return difference value.
     */
    public int compareTo(K it) {
        return theKey.compareTo(it);
    }


    /**
     * This is a getter method for the ket.
     * 
     * @return The key.
     */
    public K key() {
        return theKey;
    }


    /**
     * This is a getter method for the value.
     * 
     * @return The value.
     */
    public E value() {
        return theVal;
    }

}
