import student.TestCase;

/**
 * This is the testing case for the BinTree class.
 * 
 * @author Laith Al-Masri
 * @version Oct 6th
 */
public class BinTreeTest extends TestCase {
    private BinTree bin;
    private Seminar sem01;
    private Seminar sem02;
    private Seminar sem03;
    private Seminar sem04;
    private Seminar sem05;
    private Seminar sem06;
    private Seminar duplicate03;
    private Seminar duplicate04;
    private String[] keywords;

    /**
     * This is the setUp method where
     * everything gets instantiated.
     */
    public void setUp() {
        bin = new BinTree(0, 0, 16, 16);
        keywords = new String[3];
        keywords[0] = "Good";
        keywords[1] = "Bad";
        keywords[2] = "Ugly";

        sem01 = new Seminar(1, "1", "1", 1, (short)1, (short)1, 1, keywords,
            "1");
        sem02 = new Seminar(2, "2", "2", 2, (short)2, (short)2, 2, keywords,
            "2");
        sem03 = new Seminar(3, "3", "3", 3, (short)3, (short)3, 3, keywords,
            "3");
        sem04 = new Seminar(1, "1", "1", 1, (short)1, (short)1, 1, keywords,
            "1");
        sem05 = new Seminar(2, "2", "2", 2, (short)2, (short)2, 2, keywords,
            "2");
        sem06 = new Seminar(3, "3", "3", 3, (short)3, (short)3, 3, keywords,
            "3");
        duplicate03 = new Seminar(3, "3", "3", 3, (short)4, (short)3, 3,
            keywords, "3");
        duplicate04 = new Seminar(3, "3", "3", 3, (short)10, (short)0, 3,
            keywords, "3");
    }


    /**
     * This is the testing case for insert and print.
     */
    public void testInsertPrint() {
        bin.insert(sem05);
        bin.insert(sem04);
        bin.insert(sem01);
        bin.insert(sem02);
        bin.insert(sem03);
        bin.insert(sem06);
        bin.insert(duplicate03);
        bin.insert(duplicate04);

        bin.print(0);
        System.out.println("----");
    }


    /**
     * This is the testing case for the delete method.
     */
    public void testDelete01() {
        bin.delete(1, 1, 1);
        bin.insert(sem01);
        bin.delete(1, 2, 0);
        bin.insert(sem02);
        bin.delete(0, 1, 2);
        bin.insert(sem03);
        bin.delete(3, 2, 1);
        bin.insert(sem04);
        bin.delete(1, 1, 1);
        bin.insert(sem05);
        bin.delete(1, 1, 1);
        bin.insert(sem06);
        bin.delete(1, 1, 1);
        bin.insert(duplicate03);

        bin.print(0);
        bin.delete(2, 2, 2);
        bin.delete(3, 3, 3);
        bin.delete(4, 4, 4);
        bin.delete(5, 5, 5);
        bin.delete(6, 6, 6);
        bin.delete(7, 7, 7);
        bin.delete(0, 0, 1);
        System.out.println("----");
        bin.print(0);
    }


    /**
     * This is the testing case for the delete method.
     */
    public void testDelete02() {
        bin.insert(sem03);
        bin.insert(sem01);
        bin.insert(sem02);
        System.out.println("start of tests!!");
        bin.print(0);
        bin.delete(3, 3, 3);
        System.out.println("start of tests!!02");
        bin.print(0);
        bin.delete(2, 2, 2);
        System.out.println("start of tests!!03");
        bin.print(0);
       
    }


    /**
     * This is a test case for getting the node's children.
     */
    public void testGetLeftAndRightChild() {
        InternalNode intNode = new InternalNode();
        intNode.leftChild();
        intNode.rightChild();
    }


    /**
     * This tests the search.
     */
    public void testSearch01() {
        bin.getSize();
        bin.search(0, 0, 0);
        bin.insert(sem01);
        bin.insert(sem02);
        bin.insert(sem03);
        bin.insert(sem04);
        bin.insert(sem05);
        bin.insert(sem06);
        bin.search(1, 1, 1);
        bin.search(2, 0, 0);
        bin.search(0, 2, 0);
        bin.search(0, 0, 2);
    }


    /**
     * test search and delete.
     */
    public void testSearch02() {
        bin.search(1, 1, 1);
        bin.search(2, 0, 0);
        bin.search(10, 10, 0);
        bin.search(10, 10, 10);

        bin.insert(sem06);

        bin.search(1, 1, 1);
        bin.search(2, 0, 0);
        bin.search(10, 10, 0);
        bin.search(10, 10, 10);
        bin.delete(1, 1, 1);
        bin.insert(sem05);
        bin.search(1, 1, 1);
        bin.search(2, 0, 0);
        bin.search(10, 10, 0);
        bin.search(10, 10, 10);
        bin.delete(2, 2, 2);
        bin.insert(sem04);
        bin.search(1, 1, 1);
        bin.search(2, 0, 0);
        bin.search(10, 10, 0);
        bin.search(10, 10, 10);
        bin.insert(sem03);
        bin.search(1, 1, 1);
        bin.search(2, 0, 0);
        bin.search(10, 10, 0);
        bin.search(10, 10, 10);
        bin.insert(sem02);
        bin.search(1, 1, 1);
        bin.search(2, 0, 0);
        bin.search(10, 10, 0);
        bin.search(10, 10, 10);
        bin.insert(sem01);

        bin.search(1, 1, 1);
        bin.search(2, 0, 0);
        bin.search(0, 2, 0);
        bin.search(0, 0, 2);
    }
    
    /**
     * More test cases
     */
    public void testInsert001()
    {
        bin.insert(sem06);
        bin.insert(sem05);
        bin.insert(sem04);
        bin.insert(sem03);
        bin.insert(sem02);
        bin.insert(sem01);
        bin.insert(duplicate03);
        bin.insert(duplicate04);
    }
}
