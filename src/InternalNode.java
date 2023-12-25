
/**
 * This is the InternalNode class.
 * 
 * @author Laith Al-Masri
 * @version Oct 4th
 */
public class InternalNode implements BinNode {
    private BinNode left;
    private BinNode right;
    // private Character operator;

    /**
     * This is the constructor for this class.
     */
    public InternalNode() {
        left = new FlyWeight();
        right = new FlyWeight();
        // operator = op;
    }


    /**
     * This is a getter method for the left child.
     * 
     * @return The left child.
     */
    public BinNode leftChild() {
        return left;
    }


    /**
     * This is a getter method for the right child.
     * 
     * @return The right child.
     */
    public BinNode rightChild() {
        return right;
    }



    /**
     * This is the insert method specifically for the internal
     * node class.
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
     * @return The node we're currently in, since this
     *         is a recursive method.
     */
    @Override
    public BinNode insert(
        int depth,
        int startX,
        int startY,
        Seminar sem,
        int width,
        int height) {

        int incDepth = depth + 1;

        if (depth % 2 != 0) // working with yCoord
        {
            int lengthY = startY + height;
            int halfY = lengthY / 2;
            int halfHeight = height / 2;
            if (sem.y() >= halfY) { // checking if its on the bottom half
                right = right.insert(incDepth, startX, halfY, sem, width,
                    height);
                return this;
            }
            else { // checking if its on the top half
                left = left.insert(incDepth, startX, startY, sem, width,
                    halfHeight);
                return this;
            }
        }
        else // working with xCoord.
        {
            int lengthX = startX + width;
            int halfX = lengthX / 2;
            int halfWidth = width / 2;
            if (sem.x() >= halfX) { // checking if its on the right half
                right = right.insert(incDepth, halfX, startY, sem, width,
                    height);
                return this;
            }
            else { // checking if its on the left half
                left = left.insert(incDepth, startX, startY, sem, halfWidth,
                    height);
                return this;
            }
        }
    }


    /**
     * This is the print method.
     * It will traverse the internal nodes,
     * and once it reaches a leaf node, the print
     * method for the leaf node will be called.
     * In addition to that, if the reached node is
     * empty, the printing method for the
     * flyweight class will eventually be called.
     */
    @Override
    public void print(int indentation) {
        int depth = indentation;
        while (depth != 0) {
            System.out.print("  ");
            depth--;
        }
        int incrementIndentation = indentation + 1;
        System.out.println("I");
        // right.print(incrementIndentation);
        left.print(incrementIndentation);
        right.print(incrementIndentation);

    }


    /**
     * This is the delete method for the internal node.
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

        int lengthX = (initialX + initialWidth);
        int halfX = lengthX / 2;

        int lengthY = (initialY + initialHeight);
        int halfY = lengthY / 2;

        int incDepth = depth + 1;

        int halfWidth = initialWidth / 2;

        int halfHeight = initialHeight / 2;

        if (depth % 2 != 0) // working with y
        {
            if (halfY <= yCoord) {
                right = right.delete(incDepth, xCoord, yCoord, id, initialX,
                    halfY, initialWidth, initialHeight);
            }
            else {
                left = left.delete(incDepth, xCoord, yCoord, id, initialX,
                    initialY, initialWidth, halfHeight);
            }
        }
        else { // working with x
            if (halfX <= xCoord) {
                right = right.delete(incDepth, xCoord, yCoord, id, halfX,
                    initialY, initialWidth, initialHeight);
            }
            else {
                left = left.delete(incDepth, xCoord, yCoord, id, initialX,
                    initialY, halfWidth, initialHeight);
            }
        }
//        if (left instanceof FlyWeight && right instanceof FlyWeight) {
//            return new FlyWeight();
//        }
        if (left instanceof LeafNode && right instanceof FlyWeight) {

            return left;
        }
        else if (left instanceof FlyWeight && right instanceof LeafNode) {

            return right;
        }
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
        int count = 0;
        if (checkIntersection(xCoord, yCoord, radius, initialX, initialY,
            initialWidth, initialHeight)) {

            count++;
            if (depth % 2 != 0) // working with y.
            {
                int halfY = initialY + initialHeight / 2;
                int halfHeight = initialHeight / 2;
                int incDepth = depth + 1;

                visits = left.searchBox(incDepth, visits, xCoord, yCoord,
                    radius, initialX, initialY, initialWidth, halfHeight);
                visits = right.searchBox(incDepth, visits, xCoord, yCoord,
                    radius, initialX, halfY, initialWidth, initialHeight);

            }
            else { // working with x
                int halfX = initialX + initialWidth / 2;
                int halfWidth = initialWidth / 2;
                int incDepth = depth + 1;

                visits = left.searchBox(incDepth, visits, xCoord, yCoord,
                    radius, initialX, initialY, halfWidth, initialHeight);

                visits = right.searchBox(incDepth, visits, xCoord, yCoord,
                    radius, halfX, initialY, initialWidth, initialHeight);

            }
        }
        return visits + count;
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