/**
 * This class represents the Node for the BinTree
 * 
 * 
 * @author Laith Al-Masri
 * @version Oct 2nd
 */
public interface BinNode {

    /**
     * This is the insert method.
     * 
     * @param depth
     *            Represents the depth of each node.
     * @param startX
     *            Represents the starting point of the xCoord.
     * @param startY
     *            Represents the starting point of the yCoord.
     * @param sem
     *            Represents the object to be inserted.
     * @param width
     *            Represents the width of the world.
     * @param height
     *            Represents the height of the world.
     * @return The head node of the binTree.
     */
    public BinNode insert(
        int depth,
        int startX,
        int startY,
        Seminar sem,
        int width,
        int height);


    /**
     * This is the printing method.
     * 
     * @param depth
     *            Represents the indentation of each node.
     */
    public void print(int depth);


    /**
     * This is the delete method.
     * 
     * @param depth
     *            Represents the depth of the node in the bintree.
     * @param xCoord
     *            Represents the x point for the seminar.
     * @param yCoord
     *            Represents the y point for the seminar.
     * @param id
     *            Represents the id of the seminar.
     * @param initialX
     *            Represents the x point of the box.
     * @param initialY
     *            Represents the y point of the box.
     * @param initialWidth
     *            Represents the width of the box.
     * @param initialHeight
     *            Represents the height of the box.
     * @return The nodes after deleting the seminars from them. (headNode)
     */
    public BinNode delete(
        int depth,
        int xCoord,
        int yCoord,
        int id,
        int initialX,
        int initialY,
        int initialWidth,
        int initialHeight);

    /**
     * This is the search method.
     * 
     * @param depth
     *            Represents the depth of the node.
     * @param visits
     *            Represents the number of visits made to the nodes.
     * @param xCoord
     *            Represents the x point for the circle.
     * @param yCoord
     *            Represents the y point for the circle.
     * @param radius
     *            Represents the radius of the circle.
     * @param initialX
     *            Represents the start x point of the box.
     * @param initialY
     *            Represents the start y point of the box.
     * @param initialWidth
     *            Represents the width of the box.
     * @param initialHeight
     *            Represents the height of the box.
     * @return The number of visits that are made to the nodes.
     */
    public int searchBox(
        int depth,
        int visits,
        int xCoord,
        int yCoord,
        int radius,
        int initialX,
        int initialY,
        int initialWidth,
        int initialHeight);

}
