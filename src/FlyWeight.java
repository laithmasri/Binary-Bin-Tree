
/**
 * This is the flyweight class.
 * 
 * @author Laith Al-Masri
 * @version Oct 6th
 */
public class FlyWeight implements BinNode {
    // private static FlyWeight node = new FlyWeight();

    /**
     * This is the constructor for the class.
     */
    public FlyWeight() {
        //
    }


    /**
     * This is the insert method specifically for the fly weight node.
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
    @Override
    public BinNode insert(
        int depth,
        int startX,
        int startY,
        Seminar sem,
        int width,
        int height) {
// BinNode leafNode = new LeafNode();
// BinNode inserted = leafNode.insert(depth, sem, xCoord, yCoord);
// return inserted;
        LeafNode leafNode = new LeafNode(sem);
        return leafNode;
    }


    /**
     * This is the printing method that
     * is specifically for the fly weight node class.
     * 
     * @param indentation
     *            Represents the depth of the node in the binTree.
     */
    @Override
    public void print(int indentation) {
// InternalNode intNode = new InternalNode();
// intNode.print(depth);
        int depth = indentation;
        while (depth != 0) {
            System.out.print("  ");
            depth--;
        }
        System.out.println("E");
    }


    /**
     * This is the delete method for the flyweight node.
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
    @Override
    public BinNode delete(
        int depth,
        int xCoord,
        int yCoord,
        int id,
        int initialX,
        int initialY,
        int initialWidth,
        int initialHeight) {
        return this;

    }


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
        int initialHeight) {
        if (checkIntersection(xCoord, yCoord, radius, initialX, initialY,
            initialWidth, initialHeight)) {
            visits = visits + 1;
        }
        return visits;
    }


    /**
     * This is a helper funciton that checks if two
     * boxes intersect. The equations are taken from piazza.
     * 
     * @param xCoord
     *            Represents the x point of the circle.
     * @param yCoord
     *            Represents the y point of the circle.
     * @param radius
     *            Represents the radius of the circle.
     * @param initialX
     *            Represents the starting x point for the box.
     * @param initialY
     *            Represents the starting y point for the box.
     * @param initialWidth
     *            Represents the width of the box.
     * @param initialHeight
     *            Represents the height of the box.
     * @return True if the boxes intersect and false otherwise.
     */
    private boolean checkIntersection(
        int xCoord,
        int yCoord,
        int radius,
        int initialX,
        int initialY,
        int initialWidth,
        int initialHeight) {
        int horizontalDimension = initialX + initialWidth;
        int verticalDimension = initialY + initialHeight;

        int compare01 = 0;
        int compare02 = 0; // save this
        int compare03 = 0;
        int compare04 = 0; // save this
        if (xCoord < horizontalDimension) {
            compare01 = xCoord;
        }
        else {
            compare01 = horizontalDimension;
        }
        if (initialX > compare01) {
            compare02 = initialX;
        }
        else {
            compare02 = compare01;
        }
        if (yCoord < verticalDimension) {
            compare03 = yCoord;
        }
        else {
            compare03 = verticalDimension;
        }
        if (initialY > compare03) {
            compare04 = initialY;
        }
        else {
            compare04 = compare03;
        }

        int first = (xCoord - compare02) * (xCoord - compare02);
        int second = (yCoord - compare04) * (yCoord - compare04);
        int squareRad = radius * radius;

        return ((first + second) <= squareRad);
    }

}
