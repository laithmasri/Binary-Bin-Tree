
/**
 * This is the LeafNode class
 * 
 * @author Laith Al-Masri
 * @version Oct 4th
 */
public class LeafNode implements BinNode {
    private SinglyLinkedList<Seminar> semList = new SinglyLinkedList<Seminar>();
    // private String operand;

    /**
     * This is the constructor for the class.
     * Whenever a new LeafNode is created, the
     * object will be inserted into a linked list
     * inside that node.
     * 
     * @param sem
     *            Represents the Seminar object that will be inserted.
     * 
     */
    public LeafNode(Seminar sem) {
        semList.add(sem);
    }



    /**
     * This is the printing method specifically
     * for the leaf node class.
     * 
     * @param indentation
     *            Represents the depth of the node in the binTree.
     */
    @Override
    public void print(int indentation) {
        int numOfSeminars = semList.size();
        int depth = indentation;
        while (depth != 0) {
            System.out.print("  ");
            depth--;
        }
        System.out.print("Leaf with " + numOfSeminars + " objects: ");
        for (int x = 0; x < numOfSeminars; x++) {
            Seminar seminar = semList.get(x);
            System.out.print(seminar.id());
            if (x != numOfSeminars - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }


    /**
     * This is the insert method specifically
     * for the leaf node class. It will check
     * if the new seminar object has the same location
     * as others. If yes, it will add it to the linked list.
     * Otherwise, the leaf node will become an internal node
     * and values inside of it will be transferred into new leaf nodes.
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
        BinNode intNode = new InternalNode();
        int numOfSeminars = semList.size();
        Seminar firstSem = semList.get(0);
        if ((firstSem.x() == sem.x()) && (firstSem.y() == sem.y())) {
            semList.add(sem);
            return this;
        }
        for (int x = 0; x < numOfSeminars; x++) {
            Seminar seminar = semList.get(x);
            intNode = intNode.insert(depth, startX, startY, seminar, width,
                height);
        }
        return intNode.insert(depth, startX, startY, sem, width, height);
    }


    /**
     * This is the delete method for the leaf node.
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
        for (int x = 0; x < semList.size(); x++) {
            if (semList.get(x).id() == id) {
                semList.remove(x);
                if (semList.size() == 0) {
                    return new FlyWeight();
                }
            }
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
            for (int x = 0; x < semList.size(); x++) {
                // check the distance.
                int semX = semList.get(x).x();
                int semY = semList.get(x).y();

                int first = (semX - xCoord) * (semX - xCoord);
                int second = (semY - yCoord) * (semY - yCoord);
                int squareRad = radius * radius;

                if ((first + second) <= squareRad) {
                    int id = semList.get(x).id();
                    System.out.println("Found a record with key value " + id
                        + " at " + semX + ", " + semY);
                }
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
