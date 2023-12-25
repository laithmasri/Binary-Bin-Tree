/**
 * This is the DataBase class. It is responsible for adding seminar objects into
 * the binary tree and bin tree.
 * 
 * @param <E>Represents
 *            the comparable obj
 * @author Laith Al-Masri
 * @version Oct 2nd
 */
@SuppressWarnings("rawtypes")
public class DataBase<E extends Comparable<E>> {
    private BST<KVPair<Integer, Seminar>> idBST;
    private BST<KVPair<Integer, Seminar>> costBST;
    private BST<KVPair<String, Seminar>> dateBST;
    private BST<KVPair<String, Seminar>> keywordBST;
    private BinTree binTree;
    private int theSize;

    /**
     * This is the constructor for the DataBase class.
     * 
     * @param worldSize
     *            Represents the size of the location field.
     */
    public DataBase(int worldSize) {
        idBST = new BST<KVPair<Integer, Seminar>>();
        costBST = new BST<KVPair<Integer, Seminar>>();
        dateBST = new BST<KVPair<String, Seminar>>();
        keywordBST = new BST<KVPair<String, Seminar>>();
        int width = worldSize;
        int height = worldSize;
        binTree = new BinTree(0, 0, width, height);
        theSize = worldSize;
    }


    /**
     * This is a getter method for the size of the world.
     * 
     * @return The size of the world.
     */
    public int getWorldSize() {
        return theSize;
    }


    /**
     * This is an insert method that is used
     * to add the object to the binary trees.
     * 
     * @param seminar
     *            Represents the seminar object to be inserted.
     * @return True if inserted or false otherwise.
     */
    // @SuppressWarnings("unchecked")
    public boolean insert(Seminar seminar) {
        // This will add the id of the seminar to the id BST.
        int id = seminar.id();
        KVPair<Integer, Seminar> idValue = new KVPair<Integer, Seminar>(id,
            seminar);
        if (idBST.insertID(idValue) == false) {
            return false;
        }
        // This will add the cost of the seminar to the cost BST.
        int cost = seminar.cost();
        KVPair<Integer, Seminar> costValue = new KVPair<Integer, Seminar>(cost,
            seminar);
        costBST.insert(costValue);
        // This will add the date of the seminar to the date BST.
        String date = seminar.date();
        KVPair<String, Seminar> dateValue = new KVPair<String, Seminar>(date,
            seminar);
        dateBST.insert(dateValue);
        // This will assign a new key pair value to each keyword of the seminar.
        String[] keywords = seminar.keywords();
        for (int x = 0; x < keywords.length; x++) {
            KVPair<String, Seminar> keywordValue = new KVPair<String, Seminar>(
                keywords[x], seminar);
            keywordBST.insert(keywordValue);
        }
        binTree.insert(seminar);
        return true;
    }


    /**
     * This is the id search method.
     * 
     * @param key
     *            Represents the item to look for.
     * @return A comparable object that is found.
     */
    @SuppressWarnings("unchecked")
    public Comparable searchID(KVPair key) {
        return idBST.find(key);

    }


    /**
     * This method is used to look for
     * seminars within the specified range of cost.
     * 
     * @param low
     *            Represents the lower bound of the cost.
     * @param high
     *            Represents the upper bound of the cost.
     */
    public void searchCost(KVPair low, KVPair high) {
        int visited = costBST.findRange(costBST.getRoot(), low, high, 0);
        System.out.println(visited + " nodes visited in this search");
    }


    /**
     * This method is used to look for seminars with the specified keyword.
     * 
     * @param keyword
     *            Represents the keyword to look for.
     */
    public void searchKeyword(KVPair keyword) {
        keywordBST.findKeyword(keywordBST.getRoot(), keyword);
    }


    /**
     * This method is used to look for
     * seminars within the specified range of date.
     * 
     * @param low
     *            Represents the lower bound of the date.
     * @param high
     *            Represents the upper bound of the date.
     */
    public void searchDate(KVPair low, KVPair high) {
        int visited = dateBST.findRange(dateBST.getRoot(), low, high, 0);
        System.out.println(visited + " nodes visited in this search");
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
    public void searchLocation(int xCoord, int yCoord, int radius) {
        binTree.search(xCoord, yCoord, radius);
    }


    /**
     * This is the print id bst method.
     */
    public void printId() {

        idBST.print(idBST.getRoot(), 0);
        if (idBST.size() > 0) {
            System.out.println("Number of records: " + idBST.size());
        }

    }


    /**
     * This is the print id bst method.
     */
    public void printCost() {
        costBST.print(costBST.getRoot(), 0);
        if (costBST.size() > 0) {
            System.out.println("Number of records: " + costBST.size());
        }
    }


    /**
     * This is the print id bst method.
     */
    public void printDate() {
        dateBST.print(dateBST.getRoot(), 0);
        if (dateBST.size() > 0) {
            System.out.println("Number of records: " + dateBST.size());
        }
    }


    /**
     * This is the print id bst method.
     */
    public void printKeyword() {
        keywordBST.print(keywordBST.getRoot(), 0);
        if (keywordBST.size() > 0) {
            System.out.println("Number of records: " + keywordBST.size());
        }
    }


    /**
     * This is a getter method for the size of the id bst.
     * 
     * @return The size of the id bst.
     */
    public int checkIdSize() {
        return idBST.size();
    }


    /**
     * This is a getter method for the size of the date bst.
     * 
     * @return The size of the date bst.
     */
    public int checkDateSize() {
        return dateBST.size();
    }


    /**
     * This is a getter method for the size of the cost bst.
     * 
     * @return The size of the cost bst.
     */
    public int checkCostSize() {
        return costBST.size();
    }


    /**
     * This is a getter method for the size of the keyword bst.
     * 
     * @return The size of the keyword bst.
     */
    public int checkKeywordSize() {
        return keywordBST.size();
    }


    /**
     * This method deleted the specified KVPair from all of the bsts.
     * 
     * @param pair
     *            Represents the KVPair that needs to be removed.
     */
    public void delete(KVPair<Integer, Seminar> pair) {
        Seminar sem = pair.value();
        int id = sem.id();
        int cost = sem.cost();
        String date = sem.date();
        String[] keywords = sem.keywords();
        KVPair<Integer, Seminar> removeId = new KVPair<Integer, Seminar>(id,
            sem);
        KVPair<Integer, Seminar> removeCost = new KVPair<Integer, Seminar>(cost,
            sem);
        KVPair<String, Seminar> removeDate = new KVPair<String, Seminar>(date,
            sem);

        idBST.remove(removeId);
        costBST.remove(removeCost);
        dateBST.remove(removeDate);

        for (int x = 0; x < keywords.length; x++) {
            KVPair<String, Seminar> removeKeyword = new KVPair<String, Seminar>(
                keywords[x], sem);
            keywordBST.removeSem(keywordBST.getRoot(), removeKeyword);
            //keywordBST.remove(removeKeyword);

        }
        int xCoord = sem.x();
        int yCoord = sem.y();
        binTree.delete(xCoord, yCoord, id);
    }


    /**
     * This is the print method for the binTree.
     * 
     * @param depth
     *            Represents the depth/indentation of each node
     */
    public void printLocation(int depth) {
        System.out.println("Location Tree:");
        binTree.print(depth);
    }
}
