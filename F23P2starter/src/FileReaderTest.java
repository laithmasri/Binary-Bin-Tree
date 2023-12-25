
// import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import student.TestCase;

/**
 * This is the testing class for the FileReader
 * 
 * @author Laith Al-Masri
 * @version Oct 2nd
 */
public class FileReaderTest extends TestCase {

    /**
     * This sets up the testing cases.
     */
    public void setUp() throws FileNotFoundException {
        //
    }


    /**
     * 27 This method tests if the file reader is working fine. 28
     */

    /**
     * This testing case checks if the output
     * is the same as what's expected.
     * 
     * @throws IOException
     */
    public void testFileReader01() throws IOException {

        FileReader fileReader = new FileReader(128, "P2Sample_input (4).txt");
        String ans = systemOut().getHistory();
        String output = FileReader.readFile("P2Sample_output (4).txt");
        assertEquals(ans, output);
    }
}
