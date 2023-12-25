/**
 * This is the BST class.
 * The implementation is taken from the OpenDsa.
 * 
 * @param <E>
 *            Represents the element to be stored.
 * 
 * @author Laith Al-MAsri
 * @version Oct 2nd
 */
public class BST<E extends Comparable<E>> {
    private BSTNode<E> root;
    private int nodeCount;

    /**
     * This is the constructor for the class.
     */
    public BST() {
        root = null;
        nodeCount = 0;
    }


    /**
     * This is a getter method for the root of the BST.
     * 
     * @return The root of the BST.
     */
    public BSTNode<E> getRoot() {
        return root;
    }


    /**
     * This is the clear method.
     * It removes everything from the BST.
     */
    public void clear() {
        root = null;
        nodeCount = 0;
    }


    /**
     * This method inserts a new elements
     * into the BST.
     * 
     * @param element
     *            Represents the element to be inserted.
     * @return True if the elements is inserted
     *         or false otherwise.
     */
    public boolean insertID(E element) {
        if (find(element) == null) {
            insert(element);
            return true;
        }
        return false;

    }


    /**
     * This is the insert method.
     * 
     * @param element
     *            Represents the element to be inserted.
     */
    @SuppressWarnings("unchecked")
    public void insert(E element) {
        root = insertHelp(root, element);
        nodeCount++;
    }


    /**
     * This method inserts the element to the correct
     * position in the BST.
     * 
     * @param root
     *            Represents the root of the BST
     * @param element
     *            Represents the element to be inserted
     * @return return the root of the BST.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private BSTNode insertHelp(BSTNode rt, E element) {
        if (rt == null) {
            return new BSTNode(element);
        }
        if (rt.value().compareTo(element) >= 0) {
            rt.setLeft(insertHelp(rt.left(), element));
        }
        else {
            rt.setRight(insertHelp(rt.right(), element));
        }
        return rt;
    }


    /**
     * This is the remove method.
     * 
     * @param key
     *            Represents the key.
     * @return The the removed item.
     */
    @SuppressWarnings("unchecked")
    public E remove(E key) {
        E removed = (E)findHelp(root, key);
        if (removed != null) {
            root = removeHelp(root, key);
            nodeCount--;
        }
        return removed;
    }


    /**
     * This is the find method.
     * 
     * @param key
     *            Represents the key of the object.
     * @return The found object.
     */
    public E find(E key) {
        return (E)findHelp(root, key);
    }


    /**
     * This is a getter method for the size
     * of the BST.
     * 
     * @return The number of nodes in the BST.
     */
    public int size() {
        return nodeCount;
    }


    /**
     * This method prints the values of
     * each node in the BST in order traversal.
     * 
     * @param rt
     *            Represents the root of the BST.
     * @param depth
     *            Represents the depth of each node.
     */
    @SuppressWarnings({"unchecked"})
    public void print(BSTNode<E> rt, int depth) {
        if (size() == 0) {
            return;
        }
        if (rt == null) {
            for (int x = 0; x < depth; x++) {
                System.out.print("  ");
            }
            System.out.println("null");
            return;
        }
        print(rt.right(), depth + 1);
        for (int x = 0; x < depth; x++) {
            System.out.print("  ");

        }
        KVPair<Integer, Seminar> keyValue = (KVPair<Integer, Seminar>)rt
            .value();
        System.out.println(keyValue.key());

        print(rt.left(), depth + 1);
    }


    /**
     * This method is used to remove the
     * specified seminar object from the BST.
     * 
     * @param rt
     *            Represents the root of the table.
     * @param sem
     *            Represents the KVPair that has the
     *            seminar object.
     */
    @SuppressWarnings({"unchecked" })
    public void removeSem(BSTNode<E> rt, KVPair<String, Seminar> sem) {
        if (rt == null) {
            return;
        }
        removeSem(rt.right(), sem);
        KVPair<String, Seminar> pair = (KVPair<String, Seminar>)rt.value();
        if (pair.value().equals(sem.value()) && rt.value().compareTo(
            (E)sem) == 0) {
            rt = removeHelp(rt, sem);
            nodeCount--;
        }
        if (rt == null) {
            return;
        }
        removeSem(rt.left(), sem);
    }


    /**
     * This is a helper method that is
     * used for finding the item.
     * 
     * @param root
     *            Represents the root of the BST.
     * @param key
     *            Represents the key for the item.
     * @return A comparable object.
     */
    // @SuppressWarnings({ "unchecked", "rawtypes" })
    private E findHelp(BSTNode<E> rt, E key) {
        if (rt == null) {
            return null;
        }
        if (rt.value().compareTo((E)key) > 0) {
            return findHelp(rt.left(), key);
        }
        else if (rt.value().compareTo((E)key) < 0) {
            return findHelp(rt.right(), key);
        }

        return rt.value();
    }

// public E findKeyword(BSTNode<E> rt, E key)
// {
// return null;
// }


    /**
     * This method is used to look for
     * values in the BST that have keys
     * within a range of numbers (inclusive).
     * 
     * @param rt
     *            Represents the root of the BST.
     * @param lowPair
     *            Represents the lower bound.
     * @param highPair
     *            Represents the upper bound.
     * @param count
     *            Represents the number of visited nodes.
     * @return The number of visited nodes.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public int findRange(
        BSTNode rt,
        Comparable lowPair,
        Comparable highPair,
        int count) {
        if (rt == null) {
            count++;
            return count;
        }
        count++;
        if (rt.value().compareTo(highPair) <= 0 && rt.value().compareTo(
            lowPair) >= 0) {
            KVPair<Integer, Seminar> keyValue = (KVPair<Integer, Seminar>)rt
                .value();

            count = findRange(rt.left(), lowPair, highPair, count);
            System.out.println(keyValue.value().toString());
        }
        else if (rt.value().compareTo(lowPair) > 0) {
            count = findRange(rt.left(), lowPair, highPair, count);
        }
        if (rt.value().compareTo(highPair) < 0) {
            count = findRange(rt.right(), lowPair, highPair, count);
        }
        return count;
    }


    /**
     * This method is used to look for seminars
     * that have the specified keyword.
     * 
     * @param rt
     *            Represents the root of the BST.
     * @param key
     *            Represents the keyword that we're looking for.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void findKeyword(BSTNode rt, Comparable key) {
        if (rt == null) {
            return;
        }
        findKeyword(rt.left(), key);
        if (rt.value().compareTo(key) == 0) {
            KVPair<Integer, Seminar> keyValue = (KVPair<Integer, Seminar>)rt
                .value();
            System.out.println(keyValue.value().toString());
        }
        findKeyword(rt.right(), key);

    }

    /**
     * This is a helper method for removing.
     * 
     * @param rt
     *            Represents the root of the BST.
     * @param key
     *            Represents the key of the object.
     * @return The removed node.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private BSTNode removeHelp(BSTNode rt, Comparable key) {
        if (rt.value().compareTo(key) > 0) {
            rt.setLeft(removeHelp(rt.left(), key));
        }
        else if (rt.value().compareTo(key) < 0) {
            rt.setRight(removeHelp(rt.right(), key));
        }
        else {
            if (rt.left() == null) {
                return rt.right();
            }
            else if (rt.right() == null) {
                return rt.left();
            }
            else {
                BSTNode maxLeft = findMax(rt.left());
                rt.setValue(maxLeft.value());
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }

    /**
     * This is a helper method that finds the
     * node with the max value from the left.
     * 
     * @param rt
     *            Represents the root of the BST.
     * @return The max node.
     */
    @SuppressWarnings("rawtypes")
    public BSTNode findMax(BSTNode rt) {
        while (rt.right() != null) {
            rt = rt.right();
        }
        return rt;
    }


    /**
     * This is a helper method to delete
     * the max node.
     * 
     * @param rt
     *            Represents the root of the BST.
     * @return The deleted max node.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private BSTNode deleteMax(BSTNode rt) {
        if (rt.right() == null) {
            return rt.left();
        }
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }
}
