
/**
 * This is the BinTree class.
 * 
 * @author Laith Al-Masri
 * @version Oct 4th
 */
public class BinTree {

    private BinNode headNode;
    private int initialX;
    private int initialY;
    private int initialWidth;
    private int initialHeight;

    private int size;

    /**
     * This is the constructor of the class.
     * 
     * @param startX
     *            Represents the starting point for the xCoord.
     * @param startY
     *            Represents the starting point for the yCoord.
     * @param width
     *            Represents the width of the word.
     * @param height
     *            Represents the height of the world.
     */
    public BinTree(int startX, int startY, int width, int height) {
        initialX = startX;
        initialY = startY;
        initialWidth = width;
        initialHeight = height;
        headNode = new FlyWeight();
        // headNode = FlyWeight.getNode();
    }


    /**
     * This is a getter method for the size of the binTree.
     * 
     * @return The size of the binTree.
     */
    public int getSize() {
        return size;
    }


    /**
     * This method inserts a seminar object into the bin tree.
     * 
     * @param sem
     *            Represents the object that is being inserted.
     */
    public void insert(Seminar sem) {
        headNode = headNode.insert(0, initialX, initialY, sem, initialWidth,
            initialHeight);
    }


    /**
     * This is the search method for the bintree.
     * 
     * @param xCoord
     *            Represents the xCoord
     * @param yCoord
     *            Represents the yCoord
     * @param radius
     *            Represents the distance to look for
     */
    public void search(int xCoord, int yCoord, int radius) {
        int numOfVisits = headNode.searchBox(0, 0, xCoord, yCoord, radius,
            initialX, initialY, initialWidth, initialHeight);
        System.out.println(numOfVisits + " nodes visited in this search");
    }


    /**
     * This method initiates the call
     * to printing the binTree by calling
     * the head node.
     * 
     * @param indentation
     *            Represents the depth of each node
     *            in the bin tree.
     */
    public void print(int indentation) {
        headNode.print(indentation);
    }


    /**
     * This is the delete method
     * 
     * @param xCoord
     *            Represents the x point of the seminar.
     * @param yCoord
     *            Represents the y point of the seminar.
     * @param id
     *            Represents the id value fo the seminar
     */
    public void delete(int xCoord, int yCoord, int id) {
        headNode = headNode.delete(0, xCoord, yCoord, id, initialX, initialY,
            initialWidth, initialHeight);
    }
}
