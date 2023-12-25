import student.TestCase;

/**
 * This is the test class for the BST class.
 * 
 * @author Laith Al-MAsri
 * @version Oct 2nd
 */
public class BSTTest extends TestCase {
    @SuppressWarnings("rawtypes")
    private BST bst01;

    /**
     * This is the setUp method for the test class.
     */
    @SuppressWarnings("rawtypes")
    public void setUp() {
        bst01 = new BST();
    }


    /**
     * This testing case checks if the insert method
     * is working.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void testInsert() {
        KVPair pair = new KVPair(0, new Seminar());
        bst01.insert(pair);
        assertEquals(1, bst01.size());
    }


    /**
     * This test class checks if
     * inserting identical id values
     * would work.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testInsertIdentical() {
        KVPair pair00 = new KVPair(0, new Seminar());
        KVPair pair01 = new KVPair(1, new Seminar());
        KVPair pair11 = new KVPair(1, new Seminar());
        KVPair pair02 = new KVPair(2, new Seminar());
        KVPair pair03 = new KVPair(3, new Seminar());
        KVPair pair04 = new KVPair(4, new Seminar());

        assertTrue(bst01.insertID(pair01));
        assertFalse(bst01.insertID(pair11));
        assertTrue(bst01.insertID(pair02));
        assertTrue(bst01.insertID(pair03));
        assertTrue(bst01.insertID(pair04));
        assertTrue(bst01.insertID(pair00));
    }


    /**
     * This is a test case that checks
     * if simple remove will work.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testRemove01() {
        KVPair pair01 = new KVPair(1, new Seminar());
        KVPair pair02 = new KVPair(2, new Seminar());
        bst01.insert(pair02);
        assertEquals(pair02, bst01.remove(pair02));
        assertNull(bst01.remove(pair01));
    }


    /**
     * This is a test case that checks if
     * remove will work in certain cases.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testRemove02() {
        KVPair pair01 = new KVPair(1, new Seminar());
        KVPair pair02 = new KVPair(2, new Seminar());
        KVPair pair03 = new KVPair(3, new Seminar());
        KVPair pair04 = new KVPair(4, new Seminar());

        bst01.insert(pair02);
        bst01.insert(pair01);
        bst01.insert(pair04);
        bst01.insert(pair03);

        assertEquals(pair04, bst01.remove(pair04));
        assertEquals(pair02, bst01.remove(pair02));
        assertEquals(pair01, bst01.remove(pair01));
        assertEquals(pair03, bst01.remove(pair03));
    }


    /**
     * This test case checks if the remove
     * method works in certain scenarios.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testRemove03() {
        bst01.remove(getName());
        KVPair pair00 = new KVPair(0, new Seminar());
        KVPair pair01 = new KVPair(1, new Seminar());
        KVPair pair02 = new KVPair(2, new Seminar());
        KVPair pair03 = new KVPair(3, new Seminar());
        KVPair pair04 = new KVPair(4, new Seminar());
        KVPair pair05 = new KVPair(5, new Seminar());

        bst01.insert(pair04);
        bst01.insert(pair01);
        bst01.insert(pair00);
        bst01.insert(pair02);
        bst01.insert(pair03);
        bst01.insert(pair05);

        assertEquals(pair04, bst01.remove(pair04));
        assertEquals(pair01, bst01.remove(pair01));
    }


    /**
     * This test case checks if the find method is working.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testFind() {
        KVPair pair01 = new KVPair(1, new Seminar());
        KVPair pair02 = new KVPair(2, new Seminar());
        KVPair pair03 = new KVPair(3, new Seminar());

        bst01.insert(pair01);
        bst01.insert(pair02);
        bst01.insert(pair03);

        assertEquals(pair01, bst01.find(pair01));
        assertEquals(pair02, bst01.find(pair02));
        assertEquals(pair03, bst01.find(pair03));
    }


    /**
     * This test case checks if the clear method
     * works fine.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testClear() {
        KVPair pair01 = new KVPair(1, new Seminar());
        KVPair pair02 = new KVPair(2, new Seminar());
        KVPair pair03 = new KVPair(3, new Seminar());

        bst01.insert(pair01);
        bst01.insert(pair02);
        bst01.insert(pair03);

        assertEquals(pair01, bst01.find(pair01));
        assertEquals(pair02, bst01.find(pair02));
        assertEquals(pair03, bst01.find(pair03));

        bst01.clear();

        assertNull(bst01.find(pair01));
        assertNull(bst01.find(pair02));
        assertNull(bst01.find(pair03));
    }


    /**
     * This test case checks if
     * the printing method works correct.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testPrint() {
        KVPair pair00 = new KVPair(0, new BSTNode());
        KVPair pair01 = new KVPair(1, new BSTNode());
        KVPair pair02 = new KVPair(2, new BSTNode());
        KVPair pair03 = new KVPair(3, new BSTNode());
        KVPair pair04 = new KVPair(4, new BSTNode());
        KVPair pair05 = new KVPair(5, new BSTNode());
        KVPair pair06 = new KVPair(6, new BSTNode());

        bst01.insert(pair04);
        bst01.insert(pair01);
        bst01.insert(pair00);
        bst01.insert(pair02);
        bst01.insert(pair03);
        bst01.insert(pair06);
        bst01.insert(pair05);
        bst01.remove(pair05);

        // bst01.print(bst01.getRoot(), 0);
    }


    /**
     * This test case checks if find max is working.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testFindMax() {
        KVPair pair00 = new KVPair(0, new BSTNode());
        KVPair pair01 = new KVPair(1, new BSTNode());
        KVPair pair02 = new KVPair(2, new BSTNode());
        KVPair pair03 = new KVPair(3, new BSTNode());
        KVPair pair04 = new KVPair(4, new BSTNode());
        KVPair pair05 = new KVPair(5, new BSTNode());
        KVPair pair06 = new KVPair(6, new BSTNode());

        bst01.insert(pair04);
        bst01.insert(pair01);
        bst01.insert(pair00);
        bst01.insert(pair02);
        bst01.insert(pair03);
        bst01.insert(pair06);
        bst01.insert(pair05);
        bst01.remove(pair05);
        bst01.remove(pair06);
        bst01.remove(pair00);
        bst01.remove(pair01);
        bst01.remove(pair02);
        bst01.remove(pair03);
        bst01.remove(pair04);
    }


    /**
     * This test case checks if findKeyword is working.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void testFindKeyword() {
        String[] keywords = new String[2];
        keywords[0] = "";
        keywords[1] = "";
        Seminar sem = new Seminar(0, "", "", 0, (short)0, (short)0, 0, keywords,
            "");
        KVPair pair00 = new KVPair("", sem);
        KVPair pair01 = new KVPair("", sem);
        KVPair pair02 = new KVPair("", sem);
        KVPair pair03 = new KVPair("", sem);
        KVPair pair04 = new KVPair("", sem);
        KVPair pair05 = new KVPair("", sem);
        KVPair pair06 = new KVPair("3", sem);

        bst01.insert(pair04);
        bst01.insert(pair01);
        bst01.insert(pair00);
        bst01.insert(pair02);
        bst01.insert(pair03);
        bst01.insert(pair06);
        bst01.insert(pair05);

        bst01.findKeyword(bst01.getRoot(), pair01);
        bst01.removeSem(bst01.getRoot(), pair06);
    }


    /**
     * This testing case checks the findRange method.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testFindRange() {
        bst01.print(bst01.getRoot(), 0);
        String[] keywords = new String[2];
        keywords[0] = "";
        keywords[1] = "";
        Seminar sem = new Seminar(0, "", "", 0, (short)0, (short)0, 0, keywords,
            "");
        KVPair pair00 = new KVPair(0, sem);
        KVPair pair01 = new KVPair(-1, sem);
        KVPair pair02 = new KVPair(2, sem);
        KVPair pair03 = new KVPair(12, sem);
        KVPair pair04 = new KVPair(3, sem);
        KVPair pair05 = new KVPair(4, sem);
        KVPair pair06 = new KVPair(10, sem);

        bst01.insert(pair04);
        bst01.insert(pair01);
        bst01.insert(pair00);
        bst01.insert(pair02);
        bst01.insert(pair03);
        bst01.insert(pair06);
        bst01.insert(pair05);
        int low = 0;
        int high = 10;
        KVPair<Integer, Seminar> lower = new KVPair<Integer, Seminar>(low, sem);
        KVPair<Integer, Seminar> higher = new KVPair<Integer, Seminar>(high,
            sem);
        bst01.findRange(bst01.getRoot(), lower, higher, 0);
        bst01.print(bst01.getRoot(), 0);

    }


    /**
     * more tests
     */
    public void testRemoveEdgeCases() 
    {
        bst01.insert(getName());
        bst01.findMax(bst01.getRoot());
    }
}
