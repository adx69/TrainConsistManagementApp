import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management Application
 *
 * UC2: Add and manage passenger bogies using ArrayList
 * Demonstrates CRUD operations on a dynamic list.
 *
 * @author Lakshmi M
 * @version 1.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("======================================");
        System.out.println("   Train Consist Management App");
        System.out.println("======================================");

        // Create ArrayList for passenger bogies
        List<String> bogies = new ArrayList<>();

        // ADD bogies (Create)
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        // DISPLAY bogies (Read)
        System.out.println("\nBogies after addition:");
        System.out.println(bogies);

        // REMOVE bogie (Delete)
        bogies.remove("AC Chair");

        // CHECK existence
        boolean isSleeperPresent = bogies.contains("Sleeper");
        System.out.println("\nIs 'Sleeper' present? " + isSleeperPresent);

        // FINAL STATE
        System.out.println("\nFinal Bogie List:");
        System.out.println(bogies);

        // Program continues...
    }
}