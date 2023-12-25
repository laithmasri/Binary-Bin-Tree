/**
 * This is the BSTNode class. This code is taken from the OpenDSA.
 * 
 * @param <E>
 *            Represents the element that will be stored.
 * 
 * @author Laith Al-Masri
 * @version Oct 2nd
 */
public class BSTNode<E extends Comparable<? super E>> {
    private E element; // Element for this node
    private BSTNode<E> left; // Pointer to left child
    private BSTNode<E> right; // Pointer to right child

    /**
     * This is one of the constructors for the class.
     */
    BSTNode() {
        left = null;
        right = null;
    }


    /**
     * This is one of the constructors for the class.
     * 
     * @param val
     *            Represents the value of the stored element.
     */
    BSTNode(E val) {
        left = null;
        right = null;
        element = val;
    }


    /**
     * This is one of the constructors for the class.
     * 
     * @param val
     *            Represents the value of the stored element.
     * @param l
     *            Represents the left node.
     * @param r
     *            Represents the right node.
     */
    BSTNode(E val, BSTNode<E> l, BSTNode<E> r) {
        left = l;
        right = r;
        element = val;
    }


    /**
     * This is a getter method for the element.
     * 
     * @return The element.
     */
    public E value() {
        return element;
    }


    /**
     * This is a setter method for the element.
     * 
     * @param v
     *            Represents the new value of the element.
     */
    public void setValue(E v) {
        element = v;
    }


    /**
     * This is a getter method for the left child.
     * 
     * @return The left child.
     */
    public BSTNode<E> left() {
        return left;
    }


    /**
     * This is a setter method for the left child.
     * 
     * @param p
     *            The new value of the left child.
     */
    public void setLeft(BSTNode<E> p) {
        left = p;
    }


    /**
     * This is a getter method for the right child.
     * 
     * @return The right child.
     */
    public BSTNode<E> right() {
        return right;
    }


    /**
     * This is a setter method for the right child.
     * 
     * @param p
     *            The new value of the right child.
     */
    public void setRight(BSTNode<E> p) {
        right = p;
    }

}
