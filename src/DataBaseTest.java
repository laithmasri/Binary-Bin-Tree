import student.TestCase;

/**
 * This is the testing class for the DataBase class.
 * 
 * @author Laith Al-Masri
 * @version Oct 2nd
 */
public class DataBaseTest extends TestCase {
    private DataBase<?> db;
    private Seminar seminar01;
    private Seminar seminar02;
    private Seminar seminar03;
    private String[] keywords;

    /**
     * This is the setUp method
     * where everything is initiated
     * for the tests.
     */
    @SuppressWarnings("rawtypes")
    public void setUp() {
        keywords = new String[3];
        keywords[0] = "Good";
        keywords[1] = "Bad";
        keywords[2] = "Ugly";
        db = new DataBase(128);
        seminar01 = new Seminar(1, "1", "1", 1, (short)1, (short)1, 1, keywords,
            "1");
        seminar02 = new Seminar(2, "2", "2", 2, (short)2, (short)2, 2, keywords,
            "2");
        seminar03 = new Seminar(3, "3", "3", 3, (short)3, (short)3, 3, keywords,
            "3");
    }


    /**
     * This testing case checks if the insert
     * method functions properly.
     */
    public void testInsert() {
        db.insert(seminar01);
        db.insert(seminar02);
        db.insert(seminar03);
        Seminar sem1 = new Seminar(1, "1", "1", 1, (short)1, (short)1, 1,
            keywords, "1");
        db.insert(sem1);
    }


    /**
     * This testing case checks if the
     * printID method functions properly.
     */
    public void testPrintID() {
        db.printId();
        db.insert(seminar01);
        // db.printId();
        db.insert(seminar02);
        db.insert(seminar03);
        // db.printId();
    }


    /**
     * This testing case checks if the
     * searchId method functions properly.
     */
    public void testSearchId() {
        db.searchID(new KVPair<Integer, String>(0, ""));
    }


    /**
     * This testing case checks if edge cases
     * are tested
     */
    public void testDelete02() {
        KVPair<Integer, Seminar> node01 = new KVPair<Integer, Seminar>(1,
            seminar01);
        KVPair<Integer, Seminar> node02 = new KVPair<Integer, Seminar>(1,
            seminar02);
       
        db.insert(seminar01);
        assertEquals(1, db.checkIdSize());
        assertEquals(1, db.checkDateSize());
        assertEquals(1, db.checkCostSize());
        assertEquals(3, db.checkKeywordSize());

        System.out.println("---");
        db.printKeyword();

        db.delete(node02);
        assertEquals(1, db.checkIdSize());
        assertEquals(1, db.checkDateSize());
        assertEquals(1, db.checkCostSize());
        assertEquals(3, db.checkKeywordSize());

        db.delete(node01);
        assertEquals(0, db.checkIdSize());
        assertEquals(0, db.checkDateSize());
        assertEquals(0, db.checkCostSize());
        assertEquals(0, db.checkKeywordSize());

        System.out.println("---");
        db.printKeyword();

    }


    /**
     * This testing case checks if the
     * getWorldSize method functions properly.
     */
    public void testGetWorldSize() {
        assertEquals(128, db.getWorldSize());
    }


    /**
     * This testing case checks if the
     * print methods are working.
     */
    public void testPrintAll() {
        db.printCost();
        db.printDate();
        db.printId();
        db.printKeyword();
        db.printLocation(0);
        db.insert(seminar01);
        db.printCost();
        db.printDate();
        db.printId();
        db.printKeyword();
        db.printLocation(0);
    }


    /**
     * This method checks the search
     * commands.
     */
    public void testSearchAll() {
        db.insert(seminar01);
        db.insert(seminar02);

        db.searchCost(new KVPair<Integer, Seminar>(0, new Seminar()),
            new KVPair<Integer, Seminar>(3, new Seminar()));
        
        db.searchKeyword(new KVPair<String, Seminar>("", new Seminar()));
        
        db.searchLocation(0, 0, 0);
        
        db.searchDate(new KVPair<String, Seminar>("0", new Seminar()),
            new KVPair<String, Seminar>("3", new Seminar()));
    }
}
