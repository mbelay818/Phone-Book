package phonebook;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private final static String path1 = "/Users/MichaelM/Downloads/findData.txt";
    private final static String path2 = "/Users/MichaelM/Downloads/directoryData.txt";
    private final static File file1 = new File(path1);
    private final static File file2 = new File(path2);

    public static void main(String[] args) {
        long start;
        long end;
        ArrayList<String> directory = new ArrayList<String>();

        System.out.println("Start searching...");
        start = System.currentTimeMillis();
        addDirectoryToList(directory);
        linearSearch(directory);
        end = System.currentTimeMillis();
        searchTime(start,end);
    }

    public static void searchTime(long start, long end){
        long time  = 0;
        long seconds = 0;
        long minutes = 0;
        long millSec = 0;

        time = end - start;
        minutes = time / 60000;
        seconds = time / 1000;
        millSec = time - minutes * 60000 - seconds * 1000;
        System.out.printf("Time taken: %d min. %d sec. %d ms.",minutes,seconds,millSec);
    }

    public static void addDirectoryToList(ArrayList<String> directory){
        try (Scanner scannerFile2 = new Scanner(file2)) {
            while (scannerFile2.hasNext()) {
                scannerFile2.nextLong();
                directory.add(scannerFile2.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + path2);
        }
    }

    public static void linearSearch(ArrayList<String> directory){
        String nameFind = "";
        int countFind = 0;
        int findTotal = 0;
        try (Scanner scannerFile1 = new Scanner(file1) ) {
            while (scannerFile1.hasNext()) {
                findTotal++;
                nameFind = " " + scannerFile1.nextLine();
                if (directory.contains(nameFind)) {
                    countFind++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: "+ path1);
        }
        System.out.print("Found " + countFind + " / " + findTotal + " entries. ");
    }

}
