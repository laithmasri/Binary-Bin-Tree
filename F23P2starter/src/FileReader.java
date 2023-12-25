import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This is the file reader class.
 * It will be used to parse the input file.
 * 
 * @author laithalmasri
 * @version Sep 19th
 */
public class FileReader {
    @SuppressWarnings("rawtypes")
    private DataBase dataBase;

    /**
     * This is the constructor for the
     * FileReader class. It will call
     * a private reader method.
     * 
     * @param fileName
     *            Represents the name of the file.
     * @param worldSize
     *            Represents the size of the binTree
     *            world
     * @throws FileNotFoundException
     */
    @SuppressWarnings("rawtypes")
    public FileReader(int worldSize, String fileName)
        throws FileNotFoundException {
        dataBase = new DataBase(worldSize);
        reader(fileName);
    }


    /**
     * This method reads the input file
     * that is passed in as a parameter.
     * 
     * @param fileName
     *            Represents the name of the file.
     * @throws FileNotFoundException
     */
    // @SuppressWarnings({ "resource", "rawtypes", "unchecked" })
    @SuppressWarnings({ "unchecked", "rawtypes", "resource", "unused" })
    private void reader(String fileName) throws FileNotFoundException {
        // Creates a File object.
        File inputFile = new File(fileName);
        // Creates a Scanner object for the input file.
        Scanner scanner = new Scanner(inputFile);

        while (scanner.hasNext()) {
            String commandLine = scanner.nextLine();
            if (commandLine.contains("insert")) {
                // Parse the command and the id.
                Scanner scanner02 = new Scanner(commandLine);
                String command = scanner02.next();
                int idValue = scanner02.nextInt();
                // System.out.println(command + " " + idValue);
                // Parse the title.
                commandLine = scanner.nextLine();
                scanner02 = new Scanner(commandLine);
                String title = scanner02.nextLine();
                // System.out.println(title);
                // Parse the date, length, x, y, cost.
                commandLine = scanner.nextLine();
                scanner02 = new Scanner(commandLine);
                String date = scanner02.next();
                int length = scanner02.nextInt();
                short xCoord = scanner02.nextShort();
                short yCoord = scanner02.nextShort();
                int cost = scanner02.nextInt();
                // System.out.println(date + " " + length
                // + " " + xCoord + " " + yCoord + " " + cost);
                // Parse the keywords.
                commandLine = scanner.nextLine();
                scanner02 = new Scanner(commandLine);
                int wordCount = 0;
                while (scanner02.hasNext()) {
                    scanner02.next();
                    wordCount++;
                }
                scanner02 = new Scanner(commandLine);
                String[] keywords = new String[wordCount];
                for (int x = 0; x < wordCount; x++) {
                    keywords[x] = scanner02.next();
                    // System.out.print(x + keywords[x] + " ");
                }
                // System.out.println();
                // Parse the description.
                commandLine = scanner.nextLine();
                scanner02 = new Scanner(commandLine);
                String desc = scanner02.nextLine().trim();
                // System.out.println(desc);
                scanner02.close();

                // System.out.println("----");
                // Create a new seminar object.
                Seminar seminar = new Seminar(idValue, title, date, length,
                    xCoord, yCoord, cost, keywords, desc);
                if (xCoord >= 0 && xCoord < dataBase.getWorldSize()
                    && yCoord >= 0 && yCoord < dataBase.getWorldSize()) {
                    boolean inserted = dataBase.insert(seminar);
                    if (inserted) {
                        System.out.println(
                            "Successfully inserted record with ID " + seminar
                                .id());
                        System.out.println(seminar.toString());
                    }
                    else {
                        System.out.println("Insert FAILED - There is already "
                            + "a record with ID " + seminar.id());
                    }

                }
                else {
                    System.out.println("Insert FAILED - Bad x, y coordinates: "
                        + xCoord + ", " + yCoord);
                }
                // must add it into the bst.
            }
            else if (commandLine.contains("search")) {
                Scanner scanner02 = new Scanner(commandLine);
                String command = scanner02.next();
                String type = scanner02.next();

                if (type.equalsIgnoreCase("ID")) {
                    int searchId = scanner02.nextInt();
                    KVPair pair01 = new KVPair(searchId, new Seminar());
                    if (dataBase.searchID(pair01) != null) {
                        pair01 = (KVPair)dataBase.searchID(pair01);
                        System.out.println("Found record with ID " + searchId
                            + ":");
                        System.out.println(pair01.value().toString());
                    }
                    else {
                        System.out.println("Search FAILED -- "
                            + "There is no record with ID " + searchId);
                    }

                }
                else if (type.equalsIgnoreCase("cost")) {
                    int lowPrice = scanner02.nextInt();
                    int highPrice = scanner02.nextInt();
                    System.out.println("Seminars with costs in range "
                        + lowPrice + " to " + highPrice + ":");
                    KVPair<Integer, Seminar> lowPair =
                        new KVPair<Integer, Seminar>(lowPrice, new Seminar());
                    KVPair<Integer, Seminar> highPair =
                        new KVPair<Integer, Seminar>(highPrice, new Seminar());
                    dataBase.searchCost(lowPair, highPair);
                }
                else if (type.equalsIgnoreCase("keyword")) {
                    String searchKeyword = scanner02.next();
                    System.out.println("Seminars matching keyword "
                        + searchKeyword + ":");

                    KVPair<String, Seminar> pair01 =
                        new KVPair<String, Seminar>(searchKeyword,
                            new Seminar());
                    dataBase.searchKeyword(pair01);
                }
                else if (type.equalsIgnoreCase("location")) {
                    int x = scanner02.nextInt();
                    int y = scanner02.nextInt();
                    int radius = scanner02.nextInt();
                    System.out.println("Seminars within " + radius
                        + " units of " + x + ", " + y + ":");
                    dataBase.searchLocation(x, y, radius);
                }
                else {
                    // else if (type.equalsIgnoreCase("date"))
                    String lowDate = scanner02.next();
                    String highDate = scanner02.next();
                    System.out.println("Seminars with dates in range " + lowDate
                        + " to " + highDate + ":");
                    KVPair<String, Seminar> lowPair =
                        new KVPair<String, Seminar>(lowDate, new Seminar());
                    KVPair<String, Seminar> highPair =
                        new KVPair<String, Seminar>(highDate, new Seminar());
                    dataBase.searchDate(lowPair, highPair);
                }
                scanner02.close();
            }
            else if (commandLine.contains("delete")) {
                Scanner scanner02 = new Scanner(commandLine);
                String command = scanner02.next();
                int id = scanner02.nextInt();
                KVPair<Integer, Seminar> pair01 = new KVPair<Integer, Seminar>(
                    id, new Seminar());
                if (dataBase.searchID(pair01) != null) {
                    KVPair<Integer, Seminar> removed =
                        (KVPair<Integer, Seminar>)dataBase.searchID(pair01);
                    dataBase.delete(removed);
                    System.out.println("Record with ID " + id
                        + " successfully deleted from the database");
                    
                }
                else {
                    System.out.println("Delete FAILED -- "
                        + "There is no record with ID " + id);
                }
                scanner02.close();
            }
            else if (commandLine.contains("print")) {
                Scanner scanner02 = new Scanner(commandLine);
                String command = scanner02.next();
                String type = scanner02.next();

                if (type.equalsIgnoreCase("date")) {
                    System.out.println("Date Tree:");
                    if (dataBase.checkDateSize() == 0) {
                        System.out.println("This tree is empty");
                    }
                    dataBase.printDate();
                }
                else if (type.equalsIgnoreCase("keyword")) {
                    System.out.println("Keyword Tree:");
                    if (dataBase.checkKeywordSize() == 0) {
                        System.out.println("This tree is empty");
                    }
                    dataBase.printKeyword();
                }
                else if (type.equalsIgnoreCase("location")) {
                    dataBase.printLocation(0);
                }
                else if (type.equalsIgnoreCase("cost")) {
                    System.out.println("Cost Tree:");
                    if (dataBase.checkCostSize() == 0) {
                        System.out.println("This tree is empty");
                    }
                    dataBase.printCost();
                }
                else {

                    System.out.println("ID Tree:");
                    if (dataBase.checkIdSize() == 0) {
                        System.out.println("This tree is empty");
                    }
                    dataBase.printId();

                    // System.out.println(command + " id ");
                }
                scanner02.close();
            }
        }
        scanner.close();
    }


    /**
     * This method is used for testing purposes.
     * 
     * @param path
     *            Represents the file name.
     * @return The string printed into the console.
     * @throws IOException
     */
    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);

    }
}
